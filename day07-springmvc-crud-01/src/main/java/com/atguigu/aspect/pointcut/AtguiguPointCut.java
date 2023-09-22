package com.atguigu.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 包名:com.atguigu.aspect.pointcut
 * @author Leevi
 * 日期2023-08-29  08:54
 */
public class AtguiguPointCut {
    //@Pointcut("execution(* com.atguigu.service.impl.*Impl.*(..)) && !execution(* *..*.find*(..))")
    @Pointcut("execution(* com.atguigu.service.impl.*Impl.find*(..)) || execution(* com.atguigu.service.impl.*Impl.delete*(..))")
    //@Pointcut("execution(* com.atguigu.*.*(..))")
    public void allServiceMethod(){}
}
