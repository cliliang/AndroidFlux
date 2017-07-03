package com.cliliang.home.router;

import android.content.Context;

import com.cliliang.home.ui.MainActivity;
import com.cliliang.app.router.BaseRouter;

/**
 * desc:
 * Created by:chenliliang
 * Created on:16/5/4.
 */
public class HomeRouter extends BaseRouter {
    private static HomeRouter instance;
    public HomeRouter(Context context) {
        super(context);
        maps.put(HomeUI.MainActivigy, MainActivity.class);
    }

    public static HomeRouter getInstance(Context cnt){
        if (instance == null){
            synchronized (HomeRouter.class){
                if (instance == null){
                    instance = new HomeRouter(cnt);
                }
            }
        }
        return instance;
    }
}
