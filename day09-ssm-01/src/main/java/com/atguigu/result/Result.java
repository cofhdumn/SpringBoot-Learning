package com.atguigu.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Result
 * Package: com.atguigu.result
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 19:13
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;


    public static <T> Result ok(T data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        if (data != null) {
            result.setData(data);
        }

        return result;

    }

    public static Result ok() {
        return ok(null);
    }


    public static Result error() {
        Result result = new Result<>();
        result.setCode(500);
        result.setMessage("error");
        return result;
    }

    public static <T> Result<T> error(T data){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage("error");
        if (data!=null){
            result.setData(data);
        }
        return result;
    }
}
