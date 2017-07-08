package com.a520it.xianghacaipu.bean.disbean;

/**
 * Created by simon on 2017/6/18.
 */

public class DataBean {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "city='" + city + '\'' +
                '}';
    }
}
