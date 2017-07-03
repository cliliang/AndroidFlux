package com.cliliang.app.flux;


import com.cliliang.app.net.APIClient;
import com.cliliang.app.net.APIService;

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


}
