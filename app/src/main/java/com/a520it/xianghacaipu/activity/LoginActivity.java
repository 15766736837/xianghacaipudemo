package com.a520it.xianghacaipu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a520it.xianghacaipu.R;
import com.a520it.xianghacaipu.listerent.ILoginChangListerent;
import com.a520it.xianghacaipu.utils.SpUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {


    private EditText mLoginNameEt;
    private EditText mLoginPasswordEt;


    private Button mXz;
    private  ILoginChangListerent mListerent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }



    private void initView() {

        mLoginNameEt = (EditText) findViewById(R.id.login_name_et);
        mLoginPasswordEt = (EditText) findViewById(R.id.login_password_et);
        mLoginNameEt.addTextChangedListener(this); //设置电话样式

        findViewById(R.id.login_detil_iv).setOnClickListener(this);
        findViewById(R.id.login_return_ll).setOnClickListener(this);
        mXz = (Button) findViewById(R.id.login_xz_bt);
        mXz.setOnClickListener(this);
        findViewById(R.id.login_longin_bt).setOnClickListener(this);

        findViewById(R.id.login_register_tv).setOnClickListener(this);
        findViewById(R.id.login_verify_tv).setOnClickListener(this);
        findViewById(R.id.login_forget_tv).setOnClickListener(this);

        findViewById(R.id.login_qq_iv).setOnClickListener(this);
        findViewById(R.id.login_weixi_iv).setOnClickListener(this);
        findViewById(R.id.login_xinlang_iv).setOnClickListener(this);
        findViewById(R.id.login_youxiang_iv).setOnClickListener(this);

    }
    boolean isSelected = false;  //点击显示密码
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.login_longin_bt:  //点击登录
                login();
                break;
            case R.id.login_return_ll:  //点击退出
                finish();
                this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
                break;
            case R.id.login_detil_iv:  //账号栏点击清空
                mLoginNameEt.setText("");
                break;
            case R.id.login_xz_bt:   //密码选择样式

                if (isSelected){
                    isSelected =false;
                    mXz.setSelected(false);
                    mLoginPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    isSelected =true;
                    mXz.setSelected(true);
                    mLoginPasswordEt.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                break;
            case R.id.login_register_tv:   //注册
                startActivity(new Intent(this,RegisterActivity.class));
                this.overridePendingTransition(R.anim.open_enters_anim,R.anim.open_exits_anim);
                break;
            case R.id.login_verify_tv:   //验证
                showShare();
                break;
            case R.id.login_forget_tv:   //忘记密码
                break;
            case R.id.login_qq_iv:   //qq
                Toast.makeText(this, "抱歉此功能暂未开发", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_weixi_iv:   //微信
                Toast.makeText(this, "抱歉此功能暂未开发", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_xinlang_iv:   //新浪
                Toast.makeText(this, "抱歉此功能暂未开发", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_youxiang_iv:   //邮箱
                Toast.makeText(this, "抱歉此功能暂未开发", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void showShare() {
        Toast.makeText(this, "未开发", Toast.LENGTH_SHORT).show();
    }

    //登录
    private void login() {
        //获取输入的密码
        String name = mLoginNameEt.getText().toString().trim();
        String parssword = mLoginPasswordEt.getText().toString().trim();
        String news = name + "="+ parssword;
        //获取保存的密码
        String old = SpUtils.getString(getApplicationContext(),SpUtils.AD_NAMEPARSSWORD);
        //进行数据效验
        if ("".equals(name) || "".equals(parssword)){
            Toast.makeText(this, "账号或者密码为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!news.equals(old)){
            Toast.makeText(this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
            return;
        }else {
            //保存为已登录的状态
            SpUtils.setBoolean(getApplicationContext(),SpUtils.AD_LOGINSTATR,true);
            String username = "溘溘绊绊的一辈子";
            SpUtils.setString(getApplicationContext(),SpUtils.AD_USERNAME,username);
            //正确进行跳转
            finish();
            this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);
        }

    }

    //设置回调接口
    public  void setListerent(ILoginChangListerent listerent){
       this.mListerent = listerent;

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
