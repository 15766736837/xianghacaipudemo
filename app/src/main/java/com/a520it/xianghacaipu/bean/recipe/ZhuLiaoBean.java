package com.a520it.xianghacaipu.bean.recipe;

/**
 * Created by Administrator on 2017/7/14 0014.
 */

public class ZhuLiaoBean {
    private String oneEdt;
    private String twoEdt;

    public ZhuLiaoBean(String oneEdt, String twoEdt) {
        this.oneEdt = oneEdt;
        this.twoEdt = twoEdt;
    }

    public String getOneEdt() {
        return oneEdt;
    }

    public void setOneEdt(String oneEdt) {
        this.oneEdt = oneEdt;
    }

    public String getTwoEdt() {
        return twoEdt;
    }

    public void setTwoEdt(String twoEdt) {
        this.twoEdt = twoEdt;
    }
}
