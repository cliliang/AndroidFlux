package com.cliliang.app.flux;


import com.cliliang.app.net.APIClient;
import com.cliliang.app.net.APIService;
import com.cliliang.user.actions.LocationAction;
import com.cliliang.user.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * desc:
 *
 * Created by:chenliliang
 * Created on:16/5/10.
 */
public class AppActionsCreator {
    //用于请求数据
    private APIService apiClient;
    //用于分发事件
    private Dispatcher dispatcher;
    private AppActionsCreator(){
        apiClient = APIClient.getInstance();
        dispatcher = Dispatcher.getInstance();
    }

    private static class AppActionsCreatorHolder{
        private static final AppActionsCreator instance = new AppActionsCreator();
    }

    public static AppActionsCreator getInstance(){
        return AppActionsCreatorHolder.instance;
    }

    public void getLocation(Map<String, String> map){
        dispatcher.dispatch(new LocationAction(LocationAction.ACTION_REQUEST_START));
        apiClient.getLocation(map).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                dispatcher.dispatch(new LocationAction(LocationAction.ACTION_REQUEST_FINISH));
                User user = response.body();
                if (user != null){
                    dispatcher.dispatch(new LocationAction(LocationAction.ACTION_REQUEST_SUCCESS, user));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                dispatcher.dispatch(new LocationAction(LocationAction.ACTION_REQUEST_FINISH));
                dispatcher.dispatch(new LocationAction(LocationAction.ACTION_REQUEST_ERROR));
            }
        });
    }
}
