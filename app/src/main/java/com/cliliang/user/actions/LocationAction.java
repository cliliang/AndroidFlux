package com.cliliang.user.actions;

import com.cliliang.app.flux.Action;
import com.cliliang.user.model.LocationModel;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class LocationAction extends Action<LocationModel> {
    public static final String ACTION_REQUEST_START = "ACTION_REQUEST_LOCATION_START";
    public static final String ACTION_REQUEST_FINISH = "ACTION_REQUEST_LOCATION_FINISH";
    public static final String ACTION_REQUEST_ERROR = "ACTION_REQUEST_LOCATION_ERROR";
    public static final String ACTION_REQUEST_SUCCESS = "ACTION_REQUEST_LOCATION_SUCCESS";
    public LocationAction(String type, LocationModel data) {
        super(type, data);
    }

    public LocationAction(String type) {
        super(type);
    }
}
