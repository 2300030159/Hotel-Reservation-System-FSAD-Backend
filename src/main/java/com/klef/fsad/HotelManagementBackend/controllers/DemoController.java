package com.klef.fsad.HotelManagementBackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @RequestMapping("/greet")
    public String greet() {
        return "Greetings from the Demo Controller!";
    }
}
