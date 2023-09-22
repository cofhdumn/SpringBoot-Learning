package com.atguigu.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: Demo01Interceptor
 * Package: com.atguigu.interceptors
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 20:58
 * @Version 1.0
 */
@Component
@Slf4j
public class Demo01Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Demo01Interceptor拦截器的preHandle方法执行了");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Demo01Interceptor拦截器的postHandle方法执行了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Demo01Interceptor拦截器的afterCompletion方法执行了");    }
}
