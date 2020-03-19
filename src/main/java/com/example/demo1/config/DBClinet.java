package com.example.demo1.config;

public class DBClinet {

    private DbProperties dbProperties;

    DBClinet(DbProperties dbProperties) {

        this.dbProperties = dbProperties;
    }


    public String getConfigInfo() {
        return dbProperties.getDriveClass() == null ? "没有信息" : dbProperties.getDriveClass();
    }


}
