package com.example.project.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

    @Pointcut("execution(* com.example.project.controller.MoonController.*(..))")
    public void allMoonMethods() {}

    @Before("allMoonMethods()")
    public void logBeforeMoonMethods(JoinPoint joinPoint) {
        log.info("Entering Moon Controller  method: {} with args: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "allMoonMethods()", returning = "result")
    public void logAfterMoonMethods(JoinPoint joinPoint, Object result) {
        log.info("Moon Controller method {} returned: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "allMoonMethods()", throwing = "ex")
    public void logMoonExceptions(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in Moon Controller method {}: {}", joinPoint.getSignature(), ex.getMessage());
    }

    @Pointcut("execution(* com.example.project.controller.PlanetController.*(..))")
    public void allPlanetMethods() {}

    @Before("allPlanetMethods()")
    public void logBeforePlanetMethods(JoinPoint joinPoint) {
        log.info("Entering Planet Controller method: {} with args: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "allPlanetMethods()", returning = "result")
    public void logAfterPlanetMethods(JoinPoint joinPoint, Object result) {
        log.info("Planet Controller method {} returned: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "allPlanetMethods()", throwing = "ex")
    public void logPlanetExceptions(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception in Planet Controller method {}: {}", joinPoint.getSignature(), ex.getMessage());
    }
}
