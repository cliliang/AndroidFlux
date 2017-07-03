package com.cliliang.user.ui;

import android.os.Bundle;
import android.view.View;

import com.cliliang.R;
import com.cliliang.app.ui.BaseToolBarActivity;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class RegisterActivity extends BaseToolBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_layout);
        setTitle("注册");
        findViewById(R.id.out_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
