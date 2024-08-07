package com.EasyMall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello (){

        System.out.println("EasyMall Spring Boot2 hello world");
        return "EasyMall Spring Boot2 hello world EasyMall 易购";
    }
}
