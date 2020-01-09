package com.example.demo._23.factory.entity;

import com.example.demo._23.factory.interfaces.Communicatable;

public class Telephone implements Communicatable {

    //品牌
    private String brandName;

    //型号
    private String typeName;

    //手机imei
    private String imei;


    @Override
    public String sendMessage(String message) {
        return "FROM " + brandName + ":" + message;
    }

    public void specilShow() {
        System.out.println("===============================" );
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
