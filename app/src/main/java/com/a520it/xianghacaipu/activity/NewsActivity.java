package com.a520it.xianghacaipu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a520it.xianghacaipu.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
      Button button = (Button) findViewById(R.id.id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                NewsActivity.this.overridePendingTransition(R.anim.open_enter_anim,R.anim.open_exit_anim);

            }
        });
    }
}
