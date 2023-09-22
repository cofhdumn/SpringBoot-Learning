package com.atguigu.result;

/**
 * 包名:com.atguigu.result
 *
 * @author Leevi
 * 日期2023-08-30  11:24
 */
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result ok(){
        return ok(null);
    }

    public static <T> Result ok(T data){
        Result result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
        if (data != null){
            result.setData(data);
        }
        return result;
    }

    public static Result error(){
        Result result = new Result<>();
        result.setCode(500);
        result.setMessage("error");
        return result;
    }
}
