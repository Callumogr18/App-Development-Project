package com.example.project;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
///Lombok not working manual implementation for now
@Aspect
@Component
public class Aspects {
    private static final Logger log = LoggerFactory.getLogger(Aspects.class);
    @Pointcut("execution(* com.example.project.controller.GraphQLAPI.*(..))")
    public void allGraphQLMethods() {}

    @Before("allGraphQLMethods()")
    public void logBeforeGraphQLMethods(JoinPoint joinPoint) {
        log.info("Entering GraphQL method: {} with args: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "allGraphQLMethods()", returning = "result")
    public void logAfterGraphQLMethods(JoinPoint joinPoint, Object result) {
        log.info("GraphQL method {} returned: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "allGraphQLMethods()", throwing = "ex")
    public void logGraphQLExceptions(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in GraphQL method {}: {}", joinPoint.getSignature(), ex.getMessage());
    }
}
