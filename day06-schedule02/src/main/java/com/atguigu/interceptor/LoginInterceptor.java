package com.atguigu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor  implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //这个方法在请求被处理器处理之前执行
        //判断用户是否登录
        //1. 从请求头中获取token
        logger.info("从请求头中获取token...");
        //2. 使用token的工具类解析token、校验token
        logger.info("使用token的工具类解析token、校验token");
        //3. 如果token校验成功，则放行，并且获取用户的id，将用户的id存入ThreadLocal中
        logger.info("如果token校验成功，则放行，并且获取用户的id，将用户的id存入ThreadLocal中");
        //4. 如果token校验失败，则返回false，表示请求被拦截，并且向客户端响应code为500的json字符串
        return true;//放行

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("处理器处理完毕之后执行...postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("请求处理完毕之后执行...afterCompletion");
    }
}
