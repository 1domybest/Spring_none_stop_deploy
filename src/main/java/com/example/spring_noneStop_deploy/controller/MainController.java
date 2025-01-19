package com.example.spring_noneStop_deploy.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String mainP(HttpServletResponse response) {
        return "main Controller";
    }

}