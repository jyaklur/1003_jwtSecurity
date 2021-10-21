package com.yaklur.jwtSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class SecurityController {

    @GetMapping("/")
    public String getMapping(){
        return "You are at the default get mapping for /employees/";
    }

    @GetMapping("/home")
    public String employeesHome(){
        return "You are at the employees HOME page";
    }

    @GetMapping("/holidays")
    public String employeesHolidays(){
        return "You are at the employees HOLIDAYS page";
    }
}
