package com.example.demo._23.factory.enums;

public enum TelephoneBrandEnum {

    SAMSUNG("三星", "一个棒子的牌子" ),

    GOOGLE("google", "android系统我说了算" );

    private String brandName;

    private String desc;

    TelephoneBrandEnum(String brandName, String desc) {
        this.brandName = brandName;
        this.desc = desc;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
