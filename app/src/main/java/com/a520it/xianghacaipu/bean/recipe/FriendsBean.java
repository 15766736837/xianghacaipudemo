package com.a520it.xianghacaipu.bean.recipe;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class FriendsBean {

    /**
     * res : 2
     * data : [{"code":3149045927,"nickName":"香哈小秘书","img":"http://s1.cdn.xiangha.com/i/201507/2716/55b5e71334f86.jpg/MTAweDEwMA.webp","lv":11,"isGourmet":"2"},
     * {"code":674448987,"nickName":"管理员","img":"http://s1.cdn.xiangha.com/i/201605/3109/574cee29c68bf.jpg/MTAweDEwMA.webp","lv":6,"isGourmet":"2"}]
     * append : []
     * power : {}
     */

    private int res;
    private PowerBean power;
    private List<DataBean> data;
    private List<?> append;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public PowerBean getPower() {
        return power;
    }

    public void setPower(PowerBean power) {
        this.power = power;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<?> getAppend() {
        return append;
    }

    public void setAppend(List<?> append) {
        this.append = append;
    }

    public static class PowerBean {
    }

    public static class DataBean {
        /**
         * code : 3149045927
         * nickName : 香哈小秘书
         * img : http://s1.cdn.xiangha.com/i/201507/2716/55b5e71334f86.jpg/MTAweDEwMA.webp
         * lv : 11
         * isGourmet : 2
         */

        private long code;
        private String nickName;
        private String img;
        private int lv;
        private String isGourmet;

        public long getCode() {
            return code;
        }

        public void setCode(long code) {
            this.code = code;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getLv() {
            return lv;
        }

        public void setLv(int lv) {
            this.lv = lv;
        }

        public String getIsGourmet() {
            return isGourmet;
        }

        public void setIsGourmet(String isGourmet) {
            this.isGourmet = isGourmet;
        }
    }
}
