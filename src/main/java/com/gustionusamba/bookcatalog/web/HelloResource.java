package com.gustionusamba.bookcatalog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello from here, everything goes well, you don't need to restart manually your spring boot app. Because I have already installed Spring Boot devtools. I am happy doing this.";
    }
}
