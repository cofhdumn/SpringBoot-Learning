package com.atguigu.aspect.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: LoggingAspect
 * Package: com.atguigu.aspect.pointcut
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 19:54
 * @Version 1.0
 */
@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);



    @Before("com.atguigu.aspect.pointcut.AtguiguPointCut.allServiceMethod()")
    public void printLogBefore(JoinPoint joinPoint){
        //joinPoint: 就是目标方法的详细信息
        //日志中要记录:XX类的XX方法从XX时候开始执行，方法的参数是XX
        logger.info("[前置通知]{}类的{}方法从{}时候开始执行,方法的参数是{}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()),
                joinPoint.getArgs());
    }


    @AfterReturning(value = "com.atguigu.aspect.pointcut.AtguiguPointCut.allServiceMethod()",returning = "result")
    public void printLogAfterReturning(JoinPoint joinPoint,Object result){
        //日志中要记录:XX类的XX方法在XX时候成功结束了，方法结果是XX
        logger.info("[返回通知]{}类的{}方法在{}时候成功结束了,方法的返回值是{}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()),
                result);
    }

    @AfterThrowing(value = "com.atguigu.aspect.pointcut.AtguiguPointCut.allServiceMethod()",throwing = "t")
    public void printLogAfterThrowing(JoinPoint joinPoint,Throwable t){
        //日志中要记录:XX类的XX方法在XX时候出现了异常，异常信息是XX
        logger.error("[异常通知]{}类的{}方法在{}时候出现了异常,异常信息是{}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()),
                t);
    }

    @After("com.atguigu.aspect.pointcut.AtguiguPointCut.allServiceMethod()")
    public void printLogAfter(JoinPoint joinPoint){
        //日志中要记录:XX类的XX方法在XX时候结束了
        logger.info("[后置通知]{}类的{}方法在{}时候执行结束",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
    }

    @Around("com.atguigu.aspect.pointcut.AtguiguPointCut.allServiceMethod())")
    public Object printMethodInvokeTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //日志中要记录:XX类的XX方法的执行总时长为XX毫秒
        //1. 在目标方法执行之前，获取当前毫秒数
        long begin = System.currentTimeMillis();
        //2. 执行目标方法
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            //目标方法的异常，我们不处理，直接抛出去
            throw e;
        }finally {
            //3. 在目标方法执行结束之后(不管是否出现异常)，获取当前毫秒数
            long end = System.currentTimeMillis();
            //4. 记录日志
            logger.info("[环绕通知]{}类的{}方法的执行总时长为{}毫秒",
                    proceedingJoinPoint.getTarget().getClass().getName(),
                    proceedingJoinPoint.getSignature().getName(),
                    end-begin);
        }
    }
}
