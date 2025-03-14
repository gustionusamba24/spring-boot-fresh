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

    @Pointcut("within(com.gustionusamba.bookcatalog.web.*)")
    private void withinPointcutExample() {
    }

    @Pointcut("args(com.gustionusamba.bookcatalog.dto.PublisherCreateDTO)")
    private void argsPointcutExample() {
    }

    @Pointcut("@args(com.gustionusamba.bookcatalog.annotation.LogThisArg)")
    private void argsAnnotationPointcutExample() {
    }

    @Pointcut("@annotation(com.gustionusamba.bookcatalog.annotation.LogThisMethod)")
    private void annotationPointcutExample() {
    }

    @Before("annotationPointcutExample()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect");
    }
}
