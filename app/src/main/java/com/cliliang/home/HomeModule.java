package com.cliliang.home;

import android.content.Context;

import com.cliliang.app.module.BaseModule;
import com.cliliang.app.module.ModuleID;
import com.cliliang.app.module.ModuleNames;
import com.cliliang.app.router.BaseRouter;
import com.cliliang.home.router.HomeRouter;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/1.
 */

public class HomeModule extends BaseModule {
    public HomeModule() {
        super(ModuleID.HOME_MODULE_ID, ModuleNames.HOME_MODULE_NAME);
    }

    private static class HomeModuleHolder{
        private static final HomeModule instance = new HomeModule();
    }

    public static HomeModule getInstance(){
        return HomeModuleHolder.instance;
    }

    @Override
    public BaseRouter getRouter(Context context) {
        return HomeRouter.getInstance(context);
    }
}
