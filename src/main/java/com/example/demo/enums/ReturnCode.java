package com.example.demo.enums;

import lombok.Getter;
import lombok.Setter;

public enum  ReturnCode {

    SUCCESS("200","操作成功");


    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String message;

    ReturnCode(String code,String message){
        this.code = code;
        this.message = message;
    }

}
