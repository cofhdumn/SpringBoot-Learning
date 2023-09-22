package com.atguigu.result;

public class  Result <T>{

    private Integer code;

    private Boolean flag;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public static <T> Result <T> ok(){
        return ok(null);
    }


    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setFlag(true);
        if (data !=null){
            result.setData(data);
        }
        return result;
    }


    public static <T> Result <T> error(){
        return error(null);
    }

    public static <T> Result <T> error(T data){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setFlag(false);
        if (data !=null){
            result.setData(data);
        }
        return result;
    }


    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", flag=" + flag +
                ", data=" + data +
                '}';
    }
}
