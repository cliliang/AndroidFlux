package com.cliliang.app.config;

import android.text.TextUtils;

import com.cliliang.app.AppContext;
import com.cliliang.common.utils.JsonUtil;
import com.cliliang.user.model.User;
import com.google.gson.JsonSyntaxException;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/6/30.
 */

public class AppConfig {
    //发布正式版本时，配置isDebugVersion为false
    public static boolean isDebugVersion = false;

    private final String SAVE_USER_DATA = "save_user_data";
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

    /**
     * Test
     */
    public void saveInt(){
        preferenceManager.setValue("___", 10);
    }

    public int getInt(){
        return preferenceManager.getIntValue("___");
    }

    public void saveUserData(User model){
        if (model == null){
            return;
        }
        preferenceManager.setValue(SAVE_USER_DATA, JsonUtil.toJson(model));
    }

    public User getUserInfo(){
        User model = null;
        String jsonStr = preferenceManager.getStringValue(SAVE_USER_DATA);
        if (TextUtils.isEmpty(jsonStr)){
            return null;
        }
         try {
             model =JsonUtil.fromJson(jsonStr, User.class);
         }catch (JsonSyntaxException e){
             e.printStackTrace();
         }
         return model;
    }
}
