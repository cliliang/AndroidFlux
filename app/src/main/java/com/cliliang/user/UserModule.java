package com.cliliang.user;

import android.content.Context;

import com.cliliang.app.module.BaseModule;
import com.cliliang.app.module.ModuleID;
import com.cliliang.app.module.ModuleNames;
import com.cliliang.app.router.BaseRouter;
import com.cliliang.user.router.UserRouter;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/2.
 */

public class UserModule extends BaseModule {
    private UserModule() {
        super(ModuleID.USER_MODULE_ID, ModuleNames.USER_MODULE_NAME);
    }

    private static class UserModuleHolder{
        private static final UserModule instance = new UserModule();
    }


    public static UserModule getInstance(){
        return UserModuleHolder.instance;
    }


    @Override
    public BaseRouter getRouter(Context context) {
        return UserRouter.getInstance(context);
    }
}
