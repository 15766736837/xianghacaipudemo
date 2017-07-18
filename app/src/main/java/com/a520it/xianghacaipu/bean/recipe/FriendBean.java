package com.a520it.xianghacaipu.bean.recipe;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class FriendBean {

    int user_img;
    String user_name;
    boolean isCheck;

    public FriendBean(int user_img, String user_name, boolean isCheck) {
        this.user_img = user_img;
        this.user_name = user_name;
        this.isCheck = isCheck;
    }

    public int getUser_img() {
        return user_img;
    }

    public void setUser_img(int user_img) {
        this.user_img = user_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean check) {
        isCheck = check;
    }
}
