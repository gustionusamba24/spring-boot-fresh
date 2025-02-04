package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    private final GreetingService greetingService;

    public HelloResource(GreetingService greetingService) {
        super();
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return greetingService.sayGreeting();
    }
}
