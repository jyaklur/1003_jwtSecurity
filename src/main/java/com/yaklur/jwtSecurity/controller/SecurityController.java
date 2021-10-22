package com.yaklur.jwtSecurity.controller;

import com.yaklur.jwtSecurity.utils.JWTutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class SecurityController {

    @Autowired
    JWTutils jwtUtils;

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

    @GetMapping("/getJWTtoken/{username}")
    public String getJwtToken(@PathVariable("username") final String user) { return jwtUtils.generateToken(user); }

    @GetMapping("/getUsernameFromToken")
    public ResponseEntity<String> greeting(@RequestHeader("Authorization") String authString) {
        String responseString = ":Invalid format for JWT Token needs to start with \"Bearer \":";
        try {
            if (authString.startsWith("Bearer ")) {
                authString = authString.substring(7);
                responseString = jwtUtils.extractUsername(authString) + " is the username for:" + authString;
            }
        }
        catch(Exception e){
            responseString+=e.toString();
        }

        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }

}
