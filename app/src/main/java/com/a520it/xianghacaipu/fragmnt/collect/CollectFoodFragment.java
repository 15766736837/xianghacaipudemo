package com.a520it.xianghacaipu.fragmnt.collect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.activity.MainActivity;
import com.a520it.xianghacaipu.utils.ActivityUtils;

/**
 * Created by ASUS on 2017/7/3.
 */

public class CollectFoodFragment extends RefreshBaseFragment {


    @Override
    protected void refreshLoadData() {
        //Toast.makeText(getContext(), "菜谱", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View createView() {
        View inflate = View.inflate(getContext(), R.layout.fragment_collect_food_layout, null);
        Button  bt = (Button) inflate.findViewById(R.id.collect_food_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(MainActivity.FOOD_ID,1);
                startActivity(intent);
                ActivityUtils.statrActivity((AppCompatActivity) getContext());
            }
        });
        return inflate;
    }
}
