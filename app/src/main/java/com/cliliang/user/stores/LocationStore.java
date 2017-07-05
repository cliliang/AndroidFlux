package com.cliliang.user.stores;

import com.cliliang.app.AppContext;
import com.cliliang.app.config.AppConfig;
import com.cliliang.app.flux.Action;
import com.cliliang.app.flux.Store;
import com.cliliang.user.actions.LocationAction;
import com.cliliang.user.model.User;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class LocationStore extends Store {
    private User user = null;

    private static LocationStore instance;
    private LocationStore(){}
    public static LocationStore getInstance(){
        if (instance == null){
            instance = new LocationStore();
        }
        return instance;
    }

    public User getUser(){
        return user;
    }
    @Override
    public void onAction(Action action) {
        String type = action.getType();
        switch (type){
            case LocationAction.ACTION_REQUEST_START:
            case LocationAction.ACTION_REQUEST_FINISH:
            case LocationAction.ACTION_REQUEST_ERROR:
                emitStoreChange(type);
                break;
            case LocationAction.ACTION_REQUEST_SUCCESS:
                User model = (User) action.getData();
                if (model != null){
                    this.user = model;
                    AppConfig.getInstance().saveUserData(model);
                    AppContext.getInstance().setUserInfo(model);
                    emitStoreChange(type);
                }
                break;
        }
    }

    @Override
    public StoreChangeEvent changeEvent(String type) {
        return new StoreChangeEvent(type);
    }

    @Override
    public StoreChangeEvent changeEvent(String type, String msg) {
        return new StoreChangeEvent(type, msg);
    }
}
