package com.atguigu.result;

public class Result<T> {
    private Integer code;
    private String message;
    //    返回数据 类型为泛型
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


    public static Result ok() {
        //调用重载的方法ok
        return ok(null);
    }

    //    返回类型是泛型 Result  方法名是ok
    public static <T> Result ok(T data) {
        Result result = new Result<>();
        result.setCode(200);
        result.setMessage("success");
//        如果实参 data不等于null 塞入result Data字段
        if (data != null) {
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
