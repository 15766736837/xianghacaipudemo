package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.utils.SpUtils;

//注册界面
public class RegisterActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    private EditText mLoginNameEt;
    private EditText mLoginPasswordEt;

    private Button mXz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mLoginNameEt = (EditText) findViewById(R.id.login_name_et);
        mLoginPasswordEt = (EditText) findViewById(R.id.login_password_et);
        findViewById(R.id.login_detil_iv).setOnClickListener(this);
        findViewById(R.id.login_return_ll).setOnClickListener(this);
        mXz = (Button) findViewById(R.id.login_xz_bt);
        mXz.setOnClickListener(this);
        findViewById(R.id.login_longin_bt).setOnClickListener(this);
        mLoginNameEt.addTextChangedListener(this); //设置电话样式

    }

    boolean isSelected = false;  //点击显示密码
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_longin_bt:  //点击注册
                register();
                break;
            case R.id.login_return_ll:  //点击退出
                finish();
                this.overridePendingTransition(R.anim.open_enter_anim, R.anim.open_exit_anim);
                break;
            case R.id.login_detil_iv:  //账号栏点击清空
                mLoginNameEt.setText("");
                break;
            case R.id.login_xz_bt:   //密码选择样式
                if (isSelected) {
                    isSelected = false;
                    mXz.setSelected(false);
                    mLoginPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    isSelected = true;
                    mXz.setSelected(true);
                    mLoginPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                break;
        }


    }

    //注册
    private void register() {
        String name = mLoginNameEt.getText().toString().trim();
        String parssword = mLoginPasswordEt.getText().toString().trim();
        //数据效验
        if ("".equals(name) || "".equals(parssword)){
            Toast.makeText(this, "账号或者密码为空", Toast.LENGTH_SHORT).show();
            return;
        }else {
            String myparss = name + "=" +parssword;
            SpUtils.setString(getApplicationContext(),SpUtils.AD_NAMEPARSSWORD,myparss);
            String s = SpUtils.getString(getApplicationContext(),SpUtils.AD_NAMEPARSSWORD);
            finish();
            this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
        }
    }

    //按键点击回退
    @Override
    public void onBackPressed() {
        finish();
        this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    //显示电话的样式
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s == null || s.length() == 0) return;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                continue;
            } else {
                sb.append(s.charAt(i));
                if ((sb.length() == 4 || sb.length() == 9) && sb.charAt(sb.length() - 1) != ' ') {
                    sb.insert(sb.length() - 1, ' ');
                }
            }
        }
        if (!sb.toString().equals(s.toString())) {
            int index = start + 1;
            if (sb.charAt(start) == ' ') {
                if (before == 0) {
                    index++;
                } else {
                    index--;
                }
            } else {
                if (before == 1) {
                    index--;
                }
            }
            mLoginNameEt.setText(sb.toString());
            mLoginNameEt.setSelection(index);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}