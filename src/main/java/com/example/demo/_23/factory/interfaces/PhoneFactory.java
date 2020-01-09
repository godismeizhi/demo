package com.example.demo._23.factory.interfaces;

import com.example.demo._23.factory.entity.Telephone;
import com.example.demo._23.factory.enums.TelephoneBrandEnum;

/**
 * 单例工厂
 */
public class PhoneFactory<T> {

    private static final PhoneFactory factory = new PhoneFactory();

    //工厂
    private PhoneFactory() {

    }

    /**
     * @return
     */
    public static final PhoneFactory buildFactory() {
        return factory;
    }

    /**
     * 工厂模式获取对象
     *
     * @param
     * @return
     */
    public Telephone createPhone(TelephoneBrandEnum telephoneBrandEnum) {

        switch (telephoneBrandEnum) {
            case GOOGLE:

                break;
            case SAMSUNG:

                break;
            default:
        }

        return null;
    }

}
