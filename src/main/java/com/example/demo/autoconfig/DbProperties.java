package com.example.demo.autoconfig;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db.test")
public class DbProperties {

    private String driveClass;

    private String url;

    private String username;

    private String password;

    public String getDriveClass() {
        return driveClass;
    }

    public void setDriveClass(String driveClass) {
        this.driveClass = driveClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
