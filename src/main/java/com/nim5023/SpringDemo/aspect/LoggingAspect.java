package com.nim5023.SpringDemo.aspect;

import com.nim5023.SpringDemo.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution (public * com.nim5023.SpringDemo.service.*.*(..))")
    public void servicePointCut() {
    }

    @Before("servicePointCut()")
    public void beforeFindAllAdvice(JoinPoint joinPoint) {
        System.out.println("!!! BEFORE service ADVICE: " + joinPoint.getSignature());
    }


    @AfterReturning(pointcut = "servicePointCut()",
            returning = "result")
    public void afterFindAllAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("!!! AFTER service ADVICE: " + joinPoint.getSignature());
        System.out.println(result);
        System.out.println(result.getClass());

    }

    @Around("servicePointCut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.nanoTime();

        System.out.println("!!! Around service ADVICE start: " + joinPoint.getSignature());


        Object result = joinPoint.proceed();


        System.out.println("!!! Around service ADVICE end: " + joinPoint.getSignature());

        System.out.println(System.nanoTime() - begin);

        return result;
    }
}
