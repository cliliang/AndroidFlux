package com.cliliang.app;

import android.app.Application;
import android.util.Log;

import com.cliliang.app.module.BaseModule;
import com.cliliang.app.ui.CrashHandler;
import com.cliliang.home.HomeModule;
import com.cliliang.user.UserModule;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/6/30.
 */

public class AppContext extends Application {
    private List<BaseModule> mods = new ArrayList<>();
    private static AppContext instance;
    public static AppContext getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        fillMods();
        instance = this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

    //App增加模块时，都要在这里注册
    private void fillMods() {
        if (mods.size() == 0) {
            synchronized (AppContext.class) {
                mods.add(HomeModule.getInstance());
                mods.add(UserModule.getInstance());
            }
        }
    }

    public List<BaseModule> getMods() {
        fillMods();
        return mods;
    }
}
