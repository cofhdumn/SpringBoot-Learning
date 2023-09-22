package com.atguigu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: InvokeTime
 * Package: com.atguigu.annotation
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 21:05
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InvokeTime {
}
