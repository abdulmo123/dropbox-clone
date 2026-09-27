package com.dbc_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/home")
@RestController
public class HomeController {

    @GetMapping
    public String getHome() {
        return "/";
    }

}
