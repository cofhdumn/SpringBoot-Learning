package com.atguigu.aspect.pointcut;

import org.aspectj.lang.annotation.Pointcut;
/*
execution
	3.1 返回值类型:
		(1) * 表示任意返回值类型
		(2) 明确的返回值类型，例如int
	3.2 包名
		(1) *. 表示一级包名任意,例如: com.*.   表示只能匹配com下面还有一级包
		(2) *.. 表示任意级包名任意,例如com.*.. 表示第一级包名必须是com，后面还可以有任意级包名
		(3) 明确的包名, 例如com.atguigu.service.impl
	3.3 类名
		(1) * 表示任意类名
		(2) 部分*,例如 User* 表示以User开头的类名、 *Impl表示以Impl结尾的类名
		(3) 明确的类名
	3.4 方法名
		(1) * 表示任意方法名
		(2) 部分*,例如find* 表示以find开头的方法名, *All表示以All结尾的方法名
		(3) 明确的方法名
	3.5 参数列表
		(1) * 一个*表示一定有一个参数，但是该参数类型任意
		(2) .. 表示任意个参数
		(3) 明确的参数类型

		看的话从后往前看 参数列表 -> 方法名 -> 类名  ->包名 -> 返回值类型
 */
public class AtguiguPointCut {


    @Pointcut("execution(* com.atguigu.service.impl.*impl.find*(..)) || execution(* com.atguigu.service.impl.*impl.delete*(..))")
    public void allserviceMethod(){}
}



