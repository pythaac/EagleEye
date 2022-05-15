package com.example.slowservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowController {
    private final static Long target = 50_000_000L;

    @GetMapping(value = "/slow")
    public Long normal(){
        Long rand = (long)(Math.random() * 1000) - 500;

        long result = 0L;
        for (long t=0; t<rand+target; t++){
            result += t;
        }

        return result;
    }
}
