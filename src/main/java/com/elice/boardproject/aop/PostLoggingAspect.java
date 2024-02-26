package com.elice.boardproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PostLoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(PostLoggingAspect.class);

    public PostLoggingAspect() {
    }

    @Pointcut("execution(* com.elice.boardproject.board.controller.BoardController.*(..))")
    public void targetMethod() {
    }

    @Before("targetMethod()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("[메서드 호출 전] 호출 메서드: {}", joinPoint.getSignature().getName());
    }

    @After("targetMethod()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("[메서드 호출 후] 호출 메서드: {}", joinPoint.getSignature().getName());
    }
}