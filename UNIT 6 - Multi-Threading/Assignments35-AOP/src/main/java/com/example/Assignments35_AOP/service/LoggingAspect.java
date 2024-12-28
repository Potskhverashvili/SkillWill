package com.example.Assignments35_AOP.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("@annotation(com.example.Assignments35_AOP.service.Logger)")
    private void annotatedBy() {
    }

    @Around(value = "annotatedBy()")
    public Object aroundLogic(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime startTime = LocalDateTime.now();
        Object proceed = pjp.proceed();
        LocalDateTime endTime = LocalDateTime.now();
        Duration executionTime = Duration.between(startTime, endTime);
        System.out.println("Execution Time: " + executionTime.toMillis() + " ms");
        return proceed;
    }
}
