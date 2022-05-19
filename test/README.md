# test  
Spring boot Hello-world controller로 Monitoring  
&nbsp;  

## Grafana  
- 주소  
http://pythaac.gonetis.com:32003/d/spring_boot_21/  
- 계정  
guest/guest  
- 인스턴스  
192.168.189.112:8080 : fast-service  
192.168.189.113:8080 : normal-service  
192.168.189.114:8080 : slow-service  
&nbsp;  

## 테스트 애플리케이션  
1. fast-service
2. normal-service
3. slow-service  
&nbsp;  

### ⚡fast-service  
- /fast  
0 ~ 1_000_000 ± 500까지의 합을 하나씩 계산하여 반환  

### ⚡normal-service  
- /normal  
0 ~ 5_000_000 ± 500까지의 합을 하나씩 계산하여 반환  

### ⚡slow-service  
- /slow  
0 ~ 10_000_000 ± 500까지의 합을 하나씩 계산하여 반환  
&nbsp;  

## 테스트 에이전트  
### 🚩test-agent.py  
- 비동기 방식
- 동작 순서(무한 루프)
1. 1초 sleep
2. /fast, /normal, /slow에 각각 요청 전송
3. 응답 확인  
&nbsp;  

## 테스트 결과
### ⭐목표  
- 테스트 에이전트를 실행하여 전/후 차이를 Grafana로 확인
- /fast와 /slow의 차이를 Grafana로 확인  
&nbsp;  

### ⭐테스트 에이전트 실행 화면
<p align="center"><img src="/images/test-agent.PNG" width="50%"></img></p>  
- print를 통해 응답이 빠른 순서대로 더 많은 요청을 보내는 것을 확인  
&nbsp;  

### ⭐CPU Usage  
<p align="center"><img src="/images/test-fast-cpu.PNG" width="100%"></img><text>fast-service</text></p>  
&nbsp;  
<p align="center"><img src="/images/test-slow-cpu.PNG" width="100%"><text>slow-service</text></img></p>  
&nbsp;  
- 계산양이 더 많은 slow-service의 cpu usage가 조금 더 높은 것을 확인  

<div align="center">
  <table style="width:100%">
    <tr style="background-color:lightgrey">
      <th></th>
      <th>min</th>
      <th>max</th>
      <th>avg</th>
    </tr>
    <tr>
      <td>fast-service</td>
      <td>0.00152</td>
      <td>0.113</td>
      <td>0.0182</td>
    </tr>
    <tr>
      <td>slow-service</td>
      <td>0.00169</td>
      <td>0.232</td>
      <td>0.0766</td>
    </tr>
  </table>
</div>  
&nbsp;  

### ⭐Request  
<p align="center"><img src="/images/test-fast-request.PNG" width="100%"></img><text>fast-service</text></p>  
&nbsp;  
<p align="center"><img src="/images/test-slow-request.PNG" width="100%"><text>slow-service</text></img></p>  
&nbsp;  
- 요청 처리속도는 fast-service보다 slow-service가 약 8~9배 더 걸리는 것을 확인
- 테스트 에이전트는 응답을 받고 요청을 처리하므로, 초당 요청 개수는 fast-service가 약 3배 더 많은 것을 확인  

<div align="center">
  <table style="width:100%">
    <tr style="background-color:lightgrey">
      <th></th>
      <th>Request per sec</th>
      <th>Avg max duration</th>
      <th>Max max duration</th>
    </tr>
    <tr>
      <td>fast-service</td>
      <td>0.600</td>
      <td>0.680</td>
      <td>0.938</td>
    </tr>
    <tr>
      <td>slow-service</td>
      <td>0.200</td>
      <td>4.91</td>
      <td>7.60</td>
    </tr>
  </table>
</div>
