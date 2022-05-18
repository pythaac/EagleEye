import asyncio
import aiohttp

target = "http://localhost"

class Agent:
    def __init__(self, id, url, freq=1):
        self.id = id
        self.url = url
        self.freq = freq

    async def run(self):
        print(f"worker-{self.id} start")
        while True:
            await asyncio.sleep(self.freq)
            await self.send()

    async def send(self):
        async with aiohttp.ClientSession() as session:
            async with session.get(self.url) as r:
                if r.status != 200:
                    raise Exception("[request failed] request sent the following worker failed\n" +\
                                    self.info())
                print(f"worker-{self.id} : {await r.text()}")

    def info(self):
        return "==============================\n" +\
               f"worker-{self.id}\n" +\
               f"-- api : {self.url}\n" +\
               f"-- freq : {self.freq}\n"

async def test():
    fast = Agent("fast", f"{target}:32460/fast")
    normal = Agent("normal", f"{target}:32461/normal")
    slow = Agent("slow", f"{target}:32462/slow")

    await asyncio.gather(fast.run(), normal.run(), slow.run())


if __name__ == "__main__":
    asyncio.run(test())
