package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {
    @Around(value = "execution(* com.example.demo.services.*.*(..))")
    public Object Log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---start log:" + point.getSignature().getName());
        Object object = point.proceed();
        System.out.println("---end log:" + point.getSignature().getName());
        return object;
    }
}