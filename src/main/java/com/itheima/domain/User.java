package com.itheima.domain;

public class User {
    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPsw;
    private boolean userAd;

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + userId +
                ", User_name='" + userName + '\'' +
                ", User_Account='" + userAccount + '\'' +
                ", User_psw='" + userPsw + '\'' +
                ", User_ad=" + userAd +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public boolean isUserAd() {
        return userAd;
    }

    public void setUserAd(boolean userAd) {
        this.userAd = userAd;
    }
}
