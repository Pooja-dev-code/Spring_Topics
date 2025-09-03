package com.spring.AOP.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.spring.AOP..*.*(..))")
    //*.*(..) → means any method name with any parameters
    public void methods() {
    }

    @Pointcut("execution(* com.spring.AOP.service.*.*(int))")
    //Logs all the service classes methods that take an int argument.
    public void serviceMethods() {
    }

    @Before("methods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("🔹 [Before] Method: " + joinPoint.getSignature().getName() +
                " Args: " + java.util.Arrays.toString(joinPoint.getArgs()));
    }

    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[After] Method: " + joinPoint.getSignature().getName());
    }

}
