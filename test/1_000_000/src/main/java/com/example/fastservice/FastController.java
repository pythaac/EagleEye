package com.example.fastservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastController {
    private final static Long target = 1_000_000L;

    @GetMapping(value = "/fast")
    public Long fast(){
        Long rand = (long)(Math.random() * 1000) - 500;

        long result = 0L;
        for (long t=0; t<rand+target; t++){
            result += t;
        }

        return result;
    }
}
