package com.cliliang.app.flux;


import java.util.ArrayList;
import java.util.List;

/**
 * Flux的Dispatcher模块
 * Created by:chenliliang
 * Created on:16/5/10.
 */
public class Dispatcher {
    private final List<Store> stores;

    private Dispatcher() {
        stores = new ArrayList<>();
    }

    public static Dispatcher getInstance() {
        return DispatcherHolder.dispatcher;
    }

    private static class DispatcherHolder{
        private static final Dispatcher dispatcher = new Dispatcher();
    }

    public void register(final Store store) {
        if (!stores.contains(store)) {
            stores.add(store);
        }
    }

    public void unregister(final Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}
