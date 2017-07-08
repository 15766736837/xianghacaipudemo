package com.a520it.xianghacaipu.bean;

import java.util.List;

/**
 * Created by ASUS on 2017/6/26.
 */

public class FoodCardMSPBean {

    private DataBeanX data;
    private int res;
    private List<?> append;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX {
        /**
         * data : [{"UIStyle":"3","addTime":"2017-06-20 18:58:52","cName":"聊家常","cid":"4","city":"","click":"80","code":24069832,"commentNum":"0","content":"我的演示","customer":{"code":68104213276,"color":"#333","dishNumber":0,"duty":3,"folState":2,"img":"http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100","isGourmet":1,"lv":0,"nickName":"溘溘绊绊的一辈子","sex":"","subjectNumber":0,"url":"userIndex.app?code=68104213276"},"distance":"","floorTime":"2017-06-20 18:58:52","imgs":[],"isEssence":1,"isLike":1,"isOverHead":"0","likeNum":"1","selfVideo":"","style":1,"timeShow":"5天前","timeShowV43":"06-20","title":"演示","type":"1","url":"subjectInfo.app?code=24069832"}]
         * dataType : 1
         * prompt : {"aStr":"","aUrl":"","desc":"","name":"最新"}
         * startTime :
         */

        private int dataType;
        private PromptBean prompt;
        private String startTime;
        private List<DataBean> data;

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public PromptBean getPrompt() {
            return prompt;
        }

        public void setPrompt(PromptBean prompt) {
            this.prompt = prompt;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class PromptBean {
            /**
             * aStr :
             * aUrl :
             * desc :
             * name : 最新
             */

            private String aStr;
            private String aUrl;
            private String desc;
            private String name;

            public String getAStr() {
                return aStr;
            }

            public void setAStr(String aStr) {
                this.aStr = aStr;
            }

            public String getAUrl() {
                return aUrl;
            }

            public void setAUrl(String aUrl) {
                this.aUrl = aUrl;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class DataBean {
            /**
             * UIStyle : 3
             * addTime : 2017-06-20 18:58:52
             * cName : 聊家常
             * cid : 4
             * city :
             * click : 80
             * code : 24069832
             * commentNum : 0
             * content : 我的演示
             * customer : {"code":68104213276,"color":"#333","dishNumber":0,"duty":3,"folState":2,"img":"http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100","isGourmet":1,"lv":0,"nickName":"溘溘绊绊的一辈子","sex":"","subjectNumber":0,"url":"userIndex.app?code=68104213276"}
             * distance :
             * floorTime : 2017-06-20 18:58:52
             * imgs : []
             * isEssence : 1
             * isLike : 1
             * isOverHead : 0
             * likeNum : 1
             * selfVideo :
             * style : 1
             * timeShow : 5天前
             * timeShowV43 : 06-20
             * title : 演示
             * type : 1
             * url : subjectInfo.app?code=24069832
             */

            private String UIStyle;
            private String addTime;
            private String cName;
            private String cid;
            private String city;
            private String click;
            private int code;
            private String commentNum;
            private String content;
            private CustomerBean customer;
            private String distance;
            private String floorTime;
            private int isEssence;
            private int isLike;
            private String isOverHead;
            private String likeNum;
            private String selfVideo;
            private int style;
            private String timeShow;
            private String timeShowV43;
            private String title;
            private String type;
            private String url;
            private List<?> imgs;

            public String getUIStyle() {
                return UIStyle;
            }

            public void setUIStyle(String UIStyle) {
                this.UIStyle = UIStyle;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getCName() {
                return cName;
            }

            public void setCName(String cName) {
                this.cName = cName;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getClick() {
                return click;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(String commentNum) {
                this.commentNum = commentNum;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public CustomerBean getCustomer() {
                return customer;
            }

            public void setCustomer(CustomerBean customer) {
                this.customer = customer;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getFloorTime() {
                return floorTime;
            }

            public void setFloorTime(String floorTime) {
                this.floorTime = floorTime;
            }

            public int getIsEssence() {
                return isEssence;
            }

            public void setIsEssence(int isEssence) {
                this.isEssence = isEssence;
            }

            public int getIsLike() {
                return isLike;
            }

            public void setIsLike(int isLike) {
                this.isLike = isLike;
            }

            public String getIsOverHead() {
                return isOverHead;
            }

            public void setIsOverHead(String isOverHead) {
                this.isOverHead = isOverHead;
            }

            public String getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(String likeNum) {
                this.likeNum = likeNum;
            }

            public String getSelfVideo() {
                return selfVideo;
            }

            public void setSelfVideo(String selfVideo) {
                this.selfVideo = selfVideo;
            }

            public int getStyle() {
                return style;
            }

            public void setStyle(int style) {
                this.style = style;
            }

            public String getTimeShow() {
                return timeShow;
            }

            public void setTimeShow(String timeShow) {
                this.timeShow = timeShow;
            }

            public String getTimeShowV43() {
                return timeShowV43;
            }

            public void setTimeShowV43(String timeShowV43) {
                this.timeShowV43 = timeShowV43;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<?> getImgs() {
                return imgs;
            }

            public void setImgs(List<?> imgs) {
                this.imgs = imgs;
            }

            public static class CustomerBean {
                /**
                 * code : 68104213276
                 * color : #333
                 * dishNumber : 0
                 * duty : 3
                 * folState : 2
                 * img : http://q.qlogo.cn/qqapp/215798/E19F4F30A7E201460FC91F207078CB61/100
                 * isGourmet : 1
                 * lv : 0
                 * nickName : 溘溘绊绊的一辈子
                 * sex :
                 * subjectNumber : 0
                 * url : userIndex.app?code=68104213276
                 */

                private long code;
                private String color;
                private int dishNumber;
                private int duty;
                private int folState;
                private String img;
                private int isGourmet;
                private int lv;
                private String nickName;
                private String sex;
                private int subjectNumber;
                private String url;

                public long getCode() {
                    return code;
                }

                public void setCode(long code) {
                    this.code = code;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public int getDishNumber() {
                    return dishNumber;
                }

                public void setDishNumber(int dishNumber) {
                    this.dishNumber = dishNumber;
                }

                public int getDuty() {
                    return duty;
                }

                public void setDuty(int duty) {
                    this.duty = duty;
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

                public int getIsGourmet() {
                    return isGourmet;
                }

                public void setIsGourmet(int isGourmet) {
                    this.isGourmet = isGourmet;
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

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public int getSubjectNumber() {
                    return subjectNumber;
                }

                public void setSubjectNumber(int subjectNumber) {
                    this.subjectNumber = subjectNumber;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
