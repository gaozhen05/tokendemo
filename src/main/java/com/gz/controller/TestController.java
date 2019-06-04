package com.gz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return Base64.getEncoder().encodeToString("ok".getBytes());
    }

    @GetMapping("base")
    public String base(String base){
        byte[] decode = Base64.getDecoder().decode(base);
        String result = new String(decode);
        return result;
    }
}
