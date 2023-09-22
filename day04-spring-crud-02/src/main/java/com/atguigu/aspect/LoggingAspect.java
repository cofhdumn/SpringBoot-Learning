package com.atguigu.aspect;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//开启AOP
@Aspect
@Component
//@Order(1)
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("com.atguigu.aspect.pointcut.AtguiguPointCut.allserviceMethod()")
    public void printLogBefore(JoinPoint joinPoint) {
        logger.info("[前置通知]{}类的{}方法从{}时候开始执行，方法的参数是{}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()),
                joinPoint.getArgs());
    }

}
