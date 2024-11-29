package com.example.mvcTest.chapter05.execute;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Timer {
    @Pointcut("execution(* com.example.mvcTest..*(..))")
    public void timerTarget(){};

    @Around("timerTarget()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws  Throwable{ //프락시 패턴으로 만든거
        long start = System.nanoTime();

        //실제 메서드가 실행되는 시점이 조인 포인트
        Object result =joinPoint.proceed();
        long end = System.nanoTime();
        System.out.println("AOP 실행시간 : " + (end - start));
        return result;
    }
}
