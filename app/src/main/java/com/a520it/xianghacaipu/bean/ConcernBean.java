package com.a520it.xianghacaipu.bean;

/**
 * Created by ASUS on 2017/6/29.
 */

public class ConcernBean {


    /**
     * res : 1
     * data : 网络不稳定
     * append : {"promptMsg":"网络不稳定"}
     */

    private int res;
    private String data;
    private AppendBean append;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public AppendBean getAppend() {
        return append;
    }

    public void setAppend(AppendBean append) {
        this.append = append;
    }

    public static class AppendBean {
        /**
         * promptMsg : 网络不稳定
         */

        private String promptMsg;

        public String getPromptMsg() {
            return promptMsg;
        }

        public void setPromptMsg(String promptMsg) {
            this.promptMsg = promptMsg;
        }
    }
}
