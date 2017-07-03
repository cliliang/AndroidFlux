package com.cliliang.user.stores;

import com.cliliang.app.flux.Action;
import com.cliliang.app.flux.Store;
import com.cliliang.user.actions.LocationAction;
import com.cliliang.user.model.LocationModel;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class LocationStore extends Store {
    private LocationModel locationModel = null;

    private static LocationStore instance;
    private LocationStore(){}
    public static LocationStore getInstance(){
        if (instance == null){
            instance = new LocationStore();
        }
        return instance;
    }

    public LocationModel getLocationModel(){
        return locationModel;
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
                LocationModel model = (LocationModel) action.getData();
                if (model != null){
                    this.locationModel = model;
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
