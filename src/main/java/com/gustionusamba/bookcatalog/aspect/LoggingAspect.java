package com.gustionusamba.bookcatalog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.gustionusamba.bookcatalog.web.*.*(..))")
    private void restAPI() {
    }

    @Before("restAPI()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect");
    }
}
