package com.eduhub1.eduhub_backend1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworldcontroller {
    private final Environment environment;
    
    @Value("${spring.application.name}")
    private String appName;
    
    public Helloworldcontroller(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/hello-world")
    public String helloworld() {
        return "helloworld";
    }
    
    @GetMapping("/env")
    public String getEnvironmentVariable() {
        String port = environment.getProperty("server.port");
        return "App Name: " + appName + " Port: " + port;
    }
}