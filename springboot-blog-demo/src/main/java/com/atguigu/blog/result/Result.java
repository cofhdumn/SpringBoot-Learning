package com.atguigu.blog.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Result
 * Package: com.atguigu.blog.result
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:43
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result <T>{
    private Integer code;
    private Boolean flag;
    private T data;



    public static <T> Result<T> ok(T data){
     Result<T> reuslt = new Result<>();
     reuslt.setCode(200);
     reuslt.setFlag(true);
     if (data !=null){
         reuslt.setData(data);
     }
     return reuslt;
    }

    public static<T> Result<T> ok (){
        return ok(null);
    }

    public static<T> Result<T> error(T data){
       Result result =  new Result<>();
       result.setFlag(false);
       result.setCode(500);
       if (data != null){
           result.setData(data);
       }
       return result;
    }

    public static<T> Result<T> error(){
        return error(null);
    }
}
