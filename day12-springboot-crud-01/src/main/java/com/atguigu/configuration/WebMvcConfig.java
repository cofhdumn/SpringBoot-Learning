package com.atguigu.configuration;

import com.atguigu.interceptors.Demo01Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebMvcConfig
 * Package: com.atguigu.configuration
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/11 18:25
 * @Version 1.0
 */
@Configuration //声明为配置类注解
public class WebMvcConfig  implements WebMvcConfigurer {

    //拦截器
    @Autowired
    private Demo01Interceptor demo01Interceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demo01Interceptor)
                .addPathPatterns("/**");
    }
}
