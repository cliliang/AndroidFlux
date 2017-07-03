package com.cliliang.user.router;

import android.content.Context;

import com.cliliang.app.router.BaseRouter;
import com.cliliang.user.ui.LoginActivity;
import com.cliliang.user.ui.RegisterActivity;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class UserRouter extends BaseRouter {
    private static UserRouter instance;
    private UserRouter(Context context) {
        super(context);
        maps.put(UserUI.LoginActivity, LoginActivity.class);
        maps.put(UserUI.RegisterActivity, RegisterActivity.class);
    }

    public static UserRouter getInstance(Context cnt) {
        if (instance == null) {
            synchronized (UserRouter.class) {
                if (instance == null) {
                    instance = new UserRouter(cnt);
                }
            }
        }
        return instance;
    }
}
