package com.example.demo.refect;

@Hello("我在类上")
public class User extends SuperClass implements UserAble {

    @Hello("我在属性上")
    private String username;

    private String password;

    @Hello("我在属性上")
    public String aaaa;


    public User(String username, String password, String aaaa) {
        this.username = username;
        this.password = password;
        this.aaaa = aaaa;
    }

    @Hello("我在方法上")
    public String getAaaa() {
        return aaaa;
    }

    public void setAaaa(String aaaa) {
        this.aaaa = aaaa;
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

    @Override
    public String goHome() {
        return username + "回家";
    }
}
