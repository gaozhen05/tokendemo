package com.gz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping(value="/user/{username}")
    public Object getUserByName(@PathVariable String username) {
        Map<String,String> user = new HashMap<>();
        user.put("id","1");
        user.put("name","xm");
        user.put("password","123456");
        return user;
    }
}
