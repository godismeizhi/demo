package com.example.demo.common;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.enums.ReturnCode;
import lombok.Getter;
import lombok.Setter;

public class R<T> {

    @Setter
    private String code;

    @Setter
    private String message;

    @Setter
    @Getter
    private T data;

    private R(){
    }

    public static R getInstance(){
        return getInstance(ReturnCode.SUCCESS);
    }

    public static R getInstance(ReturnCode returnCode){
        return getInstance(returnCode,null);
    }

    public static<T> R getInstance(T data){
        return getInstance(ReturnCode.SUCCESS,data);
    }

    public static<T> R getInstance(ReturnCode returnCode,T data){
        R r  = new R();
        r.setCode(returnCode.getCode());
        r.setMessage(returnCode.getMessage());
        r.setData(data);
        return r;
    }

    public String getCode() {
        if(StringUtils.isEmpty(code)){
            code = ReturnCode.SUCCESS.getCode();
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        if(StringUtils.isEmpty(message)){
            message = ReturnCode.SUCCESS.getMessage();
        }
        return message;
    }

}
