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
 * @Create 2023/9/10 16:40
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private Boolean flag;
    private T data;

    //方法泛型 <T>  返回类型Result<T> 后面的T是方法上自带的T
    //这个static后面的T是方法泛型 可以传入ok方法的形参中
    public static <T> Result<T> ok(){
        return ok(null);
    }

    public static <T> Result<T> ok (T data){

        Result<T> result = new Result<>();
        result.setCode(200);
        result.setFlag(true);
        if (data !=null ){
            result.setData(data);
        }
        return result;

    }

    public static <T> Result<T> error(){
        return error(null);
    }

    public static <T> Result<T> error(T data){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setFlag(false);
        if (data !=null){
            result.setData(data);
        }
        return result;
    }

}
