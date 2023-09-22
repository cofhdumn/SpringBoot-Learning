package com.atguigu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ClassName: TotalTimeAspect
 * Package: com.atguigu.aspect
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 21:13
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class TotalTimeAspect {

    @Pointcut("@annotation(com.atguigu.annotation.InvokeTime)")
    public void invokeTimePointCut(){}

    @Around("invokeTimePointCut()")
    public Object methodInvokeTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = 0;
        try {
            //1. 在目标方法执行之前记录开始时间
             start = System.currentTimeMillis();
            //2. 执行目标方法
            return  proceedingJoinPoint.proceed();
        } finally {
            //3. 在目标方法执行之后记录结束时间
            long end = System.currentTimeMillis();
            //4. 计算目标方法的执行时间
            //log.info("{}类的{}方法执行了{}毫秒",proceedingJoinPoint.getTarget().getClass().getName(),proceedingJoinPoint.getSignature().getName(),(end-start));
            log.info("{}类的{}方法执行了{}毫秒",proceedingJoinPoint.getTarget().getClass().getName(),proceedingJoinPoint.getSignature().getName(),(end-start));
        }

    }
}
