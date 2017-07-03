package com.cliliang.app.module;

import android.content.Context;

import com.cliliang.app.router.BaseRouter;

public abstract class BaseModule {

    private int modId;
    private String modName;

    public BaseModule(int id, String name) {
        this.modId = id;
        this.modName = name;
    }

    public int getModId() {
        return modId;
    }


    /**
     * the module navigate router
     *
     * @param context
     * @return router or null
     */
    public abstract BaseRouter getRouter(Context context);
}
