package com.atguigu.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * ClassName: AtguiguPointCut
 * Package: com.atguigu.aspect.pointcut
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 18:15
 * @Version 1.0
 */
public class AtguiguPointCut {

    @Pointcut("execution(* com.atguigu.service.impl.*impl.fin*(..)) || execution( * com.atguigu.service.*impl.delete*(..))")
    public void allServiceMethod(){}
}
