package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

public class LoggingAspect {
	
	@Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long end = System.currentTimeMillis();

        System.out.println("Execution Time: " + (end - start) + " ms");

        return obj;
    }
}
