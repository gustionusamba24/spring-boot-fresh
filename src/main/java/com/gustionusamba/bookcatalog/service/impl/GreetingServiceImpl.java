package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.config.ApplicationProperties;
import com.gustionusamba.bookcatalog.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    private ApplicationProperties applicationProperties;

    public GreetingServiceImpl(ApplicationProperties applicationProperties) {
        super();
        this.applicationProperties = applicationProperties;
    }

    @Override
    public String sayGreeting() {
        return "The message: " + applicationProperties.getWelcomeText() + ". Your timezone: " + applicationProperties.getTimezone() + ". Your currency: " + applicationProperties.getCurrency() + ".";
    }
}
