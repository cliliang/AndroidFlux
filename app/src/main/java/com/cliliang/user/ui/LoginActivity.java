package com.cliliang.user.ui;

import android.os.Bundle;
import android.view.View;

import com.cliliang.R;
import com.cliliang.app.ui.BaseToolBarActivity;
import com.cliliang.user.router.UserRouter;
import com.cliliang.user.router.UserUI;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class LoginActivity extends BaseToolBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        setTitle("登录");
        findViewById(R.id.register_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRouter.getInstance(LoginActivity.this).showActivity(UserUI.RegisterActivity);
            }
        });
    }
}
