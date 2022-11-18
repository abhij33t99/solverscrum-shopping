package com.solverscrum.shopping.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello1(){
        return "Hello";
    }

    @GetMapping("/hello/n")
    public String Hello2(@Validated @RequestParam(value = "name") String name){
        return name;
    }

    @GetMapping("/hello/{name}")
    public String Hello3(@PathVariable String name){
        return name;
    }

}