package com.a520it.xianghacaipu.bean.disbean;

import java.util.List;

/**
 * Created by simon on 2017/6/18.
 */

public class DisBean {
    private int res;
    private DataBeanX data;
    private List<?> append;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public List<?> getAppend() {
        return append;
    }

    public void setAppend(List<?> append) {
        this.append = append;
    }
}
