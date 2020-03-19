package com.example.demo1;

public class DataBaseClinet {

    private DbProperties dbProperties;

    DataBaseClinet(DbProperties dbProperties) {

        this.dbProperties = dbProperties;
    }


    public String getConfigInfo() {
        return dbProperties.getDriveClass() == null ? "没有信息" : dbProperties.getDriveClass();
    }


}
