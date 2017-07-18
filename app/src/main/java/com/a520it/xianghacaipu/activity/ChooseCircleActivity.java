package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public class ChooseCircleActivity extends AppCompatActivity {

    private String mText = "";
    private RadioButton mRb;
    private RadioGroup mRg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_circle_layout);
        mRg = (RadioGroup) findViewById(R.id.radio_group);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = group.getCheckedRadioButtonId();
                mRb = (RadioButton) findViewById(checkedRadioButtonId);
                mText = mRb.getText().toString();
            }
        });
    }

    public void fabu(View view) {
        for (int i = 0; i < mRg.getChildCount(); i++) {
            RadioButton childAt = (RadioButton) mRg.getChildAt(i);
            if (childAt.isChecked()) {
                Toast.makeText(this, mText + "   发布成功！", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
        }
        Toast.makeText(this, "请选中内容！", Toast.LENGTH_SHORT).show();
    }

    public void guanbi(View view) {
        finish();
    }
}
