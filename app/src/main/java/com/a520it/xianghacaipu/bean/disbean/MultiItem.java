package com.a520it.xianghacaipu.bean.disbean;

/**
 * Created by simon on 2017/7/17.
 */

public class MultiItem implements com.chad.library.adapter.base.entity.MultiItemEntity {

    public static final int CONTENT = 1;
    public static final int COMMENT = 2;
    private int itemType;

    public DetailBean.DataBean.FloorBean getFloorBean() {
        return mFloorBean;
    }

    public void setFloorBean(DetailBean.DataBean.FloorBean floorBean) {
        mFloorBean = floorBean;
    }

    private DetailBean.DataBean.FloorBean mFloorBean;

    public MultiItem(int itemType) {
        this.itemType = itemType;
    }

    public MultiItem(int itemType, DetailBean.DataBean.FloorBean floorBean) {
        this.itemType = itemType;
        mFloorBean = floorBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
