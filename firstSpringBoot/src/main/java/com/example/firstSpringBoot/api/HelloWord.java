package com.example.firstSpringBoot.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord{
    @RequestMapping("/hello")
    public String sayHello(){
        return "Test-02";
    }
}
