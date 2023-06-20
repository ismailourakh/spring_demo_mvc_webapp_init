package com.example.spring_demo_mvc_webapp_init.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HomeController {
    @GetMapping("/register")
    public String register(){
        return "index";
    }
}
