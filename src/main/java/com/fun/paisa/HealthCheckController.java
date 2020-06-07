package com.fun.paisa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/health-check")
public class HealthCheckController {

    @GetMapping
    public String index() {
        return "I am good to go, stay safe from corona";
    }
}
