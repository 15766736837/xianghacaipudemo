package com.a520it.xianghacaipu.bean.disbean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by simon on 2017/7/19.
 */

public class NewestMultiltem implements MultiItemEntity {
    public static final int CONTENT = 1;
    public static final int COMMENT = 2;

    @Override
    public int getItemType() {
        return 0;
    }
}
