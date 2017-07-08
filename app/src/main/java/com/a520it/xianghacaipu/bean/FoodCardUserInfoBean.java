package com.a520it.xianghacaipu.bean;

import java.util.List;

/**
 * Created by ASUS on 2017/6/26.
 */

public class FoodCardUserInfoBean {

    private DataBean data;
    private int res;
    private List<?> append;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<?> getAppend() {
        return append;
    }

    public void setAppend(List<?> append) {
        this.append = append;
    }

    public static class DataBean {
        /**
         * userinfo : {"bigImg":"http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100","code":68104213276,"dishCount":"0","fanNum":"0","folState":2,"img":"http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100","inTime":"2017-06-15","info":"","isGourmet":1,"likeNum":"1","lv":0,"nickName":"溘溘绊绊的一辈子","popNum":0,"sex":"1","state":"5","subjectCount":"1","vip":{"color":"","first_time":"","isVip":1,"last_time":"","level":0,"maturity_time":"","text":"","xiangdou":"0"}}
         */

        private UserinfoBean userinfo;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public static class UserinfoBean {
            /**
             * bigImg : http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100
             * code : 68104213276
             * dishCount : 0
             * fanNum : 0
             * folState : 2
             * img : http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100
             * inTime : 2017-06-15
             * info :
             * isGourmet : 1
             * likeNum : 1
             * lv : 0
             * nickName : 溘溘绊绊的一辈子
             * popNum : 0
             * sex : 1
             * state : 5
             * subjectCount : 1
             * vip : {"color":"","first_time":"","isVip":1,"last_time":"","level":0,"maturity_time":"","text":"","xiangdou":"0"}
             */

            private String bigImg;
            private long code;
            private String dishCount;
            private String fanNum;
            private int folState;
            private String img;
            private String inTime;
            private String info;
            private int isGourmet;
            private String likeNum;
            private int lv;
            private String nickName;
            private int popNum;
            private String sex;
            private String state;
            private String subjectCount;
            private VipBean vip;

            public String getBigImg() {
                return bigImg;
            }

            public void setBigImg(String bigImg) {
                this.bigImg = bigImg;
            }

            public long getCode() {
                return code;
            }

            public void setCode(long code) {
                this.code = code;
            }

            public String getDishCount() {
                return dishCount;
            }

            public void setDishCount(String dishCount) {
                this.dishCount = dishCount;
            }

            public String getFanNum() {
                return fanNum;
            }

            public void setFanNum(String fanNum) {
                this.fanNum = fanNum;
            }

            public int getFolState() {
                return folState;
            }

            public void setFolState(int folState) {
                this.folState = folState;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getInTime() {
                return inTime;
            }

            public void setInTime(String inTime) {
                this.inTime = inTime;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public int getIsGourmet() {
                return isGourmet;
            }

            public void setIsGourmet(int isGourmet) {
                this.isGourmet = isGourmet;
            }

            public String getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(String likeNum) {
                this.likeNum = likeNum;
            }

            public int getLv() {
                return lv;
            }

            public void setLv(int lv) {
                this.lv = lv;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getPopNum() {
                return popNum;
            }

            public void setPopNum(int popNum) {
                this.popNum = popNum;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getSubjectCount() {
                return subjectCount;
            }

            public void setSubjectCount(String subjectCount) {
                this.subjectCount = subjectCount;
            }

            public VipBean getVip() {
                return vip;
            }

            public void setVip(VipBean vip) {
                this.vip = vip;
            }

            public static class VipBean {
                /**
                 * color :
                 * first_time :
                 * isVip : 1
                 * last_time :
                 * level : 0
                 * maturity_time :
                 * text :
                 * xiangdou : 0
                 */

                private String color;
                private String first_time;
                private int isVip;
                private String last_time;
                private int level;
                private String maturity_time;
                private String text;
                private String xiangdou;

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getFirst_time() {
                    return first_time;
                }

                public void setFirst_time(String first_time) {
                    this.first_time = first_time;
                }

                public int getIsVip() {
                    return isVip;
                }

                public void setIsVip(int isVip) {
                    this.isVip = isVip;
                }

                public String getLast_time() {
                    return last_time;
                }

                public void setLast_time(String last_time) {
                    this.last_time = last_time;
                }

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public String getMaturity_time() {
                    return maturity_time;
                }

                public void setMaturity_time(String maturity_time) {
                    this.maturity_time = maturity_time;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getXiangdou() {
                    return xiangdou;
                }

                public void setXiangdou(String xiangdou) {
                    this.xiangdou = xiangdou;
                }
            }
        }
    }
}
