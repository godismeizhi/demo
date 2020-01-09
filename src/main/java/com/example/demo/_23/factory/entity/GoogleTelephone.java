package com.example.demo._23.factory.entity;

import com.example.demo._23.factory.enums.TelephoneBrandEnum;

public class GoogleTelephone extends Telephone {

    public static final String BRAND_NAME = TelephoneBrandEnum.GOOGLE.getBrandName();

    GoogleTelephone() {
        super();
        this.setBrandName(BRAND_NAME);
    }

    @Override
    public void specilShow() {
        System.out.println("google_show" );
    }
}
