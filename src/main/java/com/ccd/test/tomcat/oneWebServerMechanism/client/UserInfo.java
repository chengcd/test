package com.ccd.test.tomcat.oneWebServerMechanism.client;

/**
 * Created by ccd on 2018/1/30.
 */
public class UserInfo {
    private String name;//用户名
    private String psw;//密码
    private String loginTime;//上线时间
    private String address;//上线地址
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public String getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
