package com.klef.fsad.HotelManagementBackend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://hotel-reservation-system-fsad.vercel.app"
})
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
