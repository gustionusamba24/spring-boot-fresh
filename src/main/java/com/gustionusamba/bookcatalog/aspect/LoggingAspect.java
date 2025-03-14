package com.gustionusamba.bookcatalog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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

    //    Advice
    @Before("annotationPointcutExample()")
    public void beforeExecutedLogging() {
        log.info("this is log from aspect before method executed");
    }

    @After("annotationPointcutExample()")
    public void afterExecutedLogging() {
        log.info("this is log from aspect after method executed");
    }

    @AfterReturning("annotationPointcutExample()")
    public void afterReturningExecutedLogging() {
        log.info("this is log from aspect after returning method executed");
    }

    @AfterThrowing("annotationPointcutExample()")
    public void afterThrowingExecutedLogging() {
        log.info("this is log from aspect after throwing method executed");
    }

    @Around("restAPI()")
    public Object processingTimeLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        try {
            log.info("start {}.{}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
            stopWatch.start();
        } finally {
            stopWatch.stop();
            log.info("finish {}.{} execution time = {}",
                    joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName(),
                    stopWatch.getTotalTimeMillis());
        }
        return joinPoint.proceed();
    }
}
