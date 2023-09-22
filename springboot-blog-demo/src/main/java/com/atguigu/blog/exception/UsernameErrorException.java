package com.atguigu.blog.exception;

/**
 * ClassName: UsernameErrorException
 * Package: com.atguigu.blog.exception
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/21 9:43
 * @Version 1.0
 */
public class UsernameErrorException  extends RuntimeException{


    public UsernameErrorException(String message){
        super(message);
    }
}
