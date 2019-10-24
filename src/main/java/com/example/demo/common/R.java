package com.example.demo.common;


import com.example.demo.enums.ResponseCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

@ApiModel("返回信息")
public class R<T> {

    @ApiModelProperty("返回码")
    private String code;

    @ApiModelProperty("描述")
    private String message;

    @ApiModelProperty("信息")
    private T data;

    private R() {
    }

    public static R getInstance() {
        return getInstance(ResponseCode.SUCCESS);
    }

    public static R getInstance(ResponseCode returnCode) {
        return getInstance(returnCode, null);
    }

    public static <T> R getInstance(T data) {
        return getInstance(ResponseCode.SUCCESS, data);
    }

    public static <T> R getInstance(ResponseCode returnCode, T data) {
        R r = new R();
        r.setCode(returnCode.getCode());
        r.setMessage(returnCode.getMessage());
        r.setData(data);
        return r;
    }

    public String getCode() {
        if (StringUtils.isEmpty(code)) {
            code = ResponseCode.SUCCESS.getCode();
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        if (StringUtils.isEmpty(message)) {
            message = ResponseCode.SUCCESS.getMessage();
        }
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
}
