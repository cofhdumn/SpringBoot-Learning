package com.atguigu.blog.exception;

/**
 * ClassName: PasswordErrorException
 * Package: com.atguigu.blog.exception
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/21 9:46
 * @Version 1.0
 */
public class PasswordErrorException extends RuntimeException {
    public PasswordErrorException(String message){
        super(message);
    }
}
