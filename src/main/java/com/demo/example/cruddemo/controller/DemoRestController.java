package com.demo.example.cruddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class DemoRestController {

    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}
