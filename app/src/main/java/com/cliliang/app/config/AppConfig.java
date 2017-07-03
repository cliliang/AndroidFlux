package com.cliliang.app.config;

import com.cliliang.app.AppContext;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/6/30.
 */

public class AppConfig {
    //发布正式版本时，配置isDebugVersion为false
    public static boolean isDebugVersion = false;

    private SharePreferenceManager preferenceManager;
    private AppConfig(){
        preferenceManager = SharePreferenceManager.newInstance(AppContext.getInstance());
    }
    public static AppConfig getInstance(){
        return AppConfigHolder.appConfig;
    }

    private static class AppConfigHolder{
        private static final AppConfig appConfig = new AppConfig();
    }

    public void saveInt(){
        preferenceManager.setValue("___", 10);
    }

    public int getInt(){
        return preferenceManager.getIntValue("___");
    }
}
