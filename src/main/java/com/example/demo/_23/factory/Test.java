package com.example.demo._23.factory;

import com.example.demo._23.factory.entity.Telephone;
import com.example.demo._23.factory.enums.TelephoneBrandEnum;
import com.example.demo._23.factory.interfaces.PhoneFactory;

public class Test {

    public static void main(String[] args) {

        PhoneFactory phoneFactory = PhoneFactory.buildFactory();

        Telephone telephone = phoneFactory.createPhone(TelephoneBrandEnum.GOOGLE);

        telephone.specilShow();
    }
}
