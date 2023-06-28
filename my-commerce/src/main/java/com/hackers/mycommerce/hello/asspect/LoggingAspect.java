package com.hackers.mycommerce.hello.asspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.hackers.mycommerce.hello.*.hello*(..))")
    public void loggerBefore() {
        //System.out.println("hello로 시작하는 메서드가 시작됩니다.");
        logger.info("hello로 시작하는 메서드가 시작됩니다.");
    }

    @After("execution(* com.hackers.mycommerce.hello.*.hello*(..))")
    public void loggerAfter() {
        //System.out.println("hello로 시작하는 메서드가 끝났습니다.");
        logger.info("hello로 시작하는 메서드가 끝났습니다");
    }

    @Around("execution(* com.hackers.mycommerce.hello.HelloController.*(..))")
    public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
        long beforeTimeMillis = System.currentTimeMillis();
//        System.out.println("[HelloController] 실행 시작 : "
//                +pjp.getSignature().getDeclaringTypeName() + "."
//                +pjp.getSignature().getName());
        logger.info("[HelloController] 실행 시작 : "
               +pjp.getSignature().getDeclaringTypeName() + "."
                +pjp.getSignature().getName());
        Object result = pjp.proceed();

        long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
//        System.out.println("[HelloController] 실행 완료: " + afterTimeMillis + "밀리초 소요"
//                +pjp.getSignature().getDeclaringTypeName() + "."
//                +pjp.getSignature().getName());

        logger.info("[HelloController] 실행 완료: " + afterTimeMillis + "밀리초 소요"
                +pjp.getSignature().getDeclaringTypeName() + "."
                +pjp.getSignature().getName());
        return result;
    }
}
