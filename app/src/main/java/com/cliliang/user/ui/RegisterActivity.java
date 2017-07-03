package com.cliliang.user.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cliliang.R;
import com.cliliang.app.flux.Store;
import com.cliliang.app.ui.BaseToolBarActivity;
import com.cliliang.user.actions.LocationAction;
import com.cliliang.user.model.LocationModel;
import com.cliliang.user.stores.LocationStore;
import com.squareup.otto.Subscribe;

import java.util.HashMap;
import java.util.Map;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class RegisterActivity extends BaseToolBarActivity {
    private LocationStore store;
    private TextView infoView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_layout);
        setTitle("注册");
        findViewById(R.id.out_activity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> map = new HashMap<>();
                map.put("a", "固始");
                appActionsCreator.getLocation(map);
            }
        });
        initDependencies();
        setupViews();
    }

    @Override
    protected void setupViews() {
        super.setupViews();
        infoView = (TextView) findViewById(R.id.out_activity_display_info);
    }

    @Override
    protected void initDependencies() {
        super.initDependencies();
        store = LocationStore.getInstance();
        dispatcher.register(store);
    }

    @Override
    protected void onResume() {
        super.onResume();
        store.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        store.unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispatcher.unregister(store);
    }

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event){
        String type = event.getType();
        switch (type){
            case LocationAction.ACTION_REQUEST_START:
                showProgress("", "请求数据");
                break;
            case LocationAction.ACTION_REQUEST_FINISH:
                hideProgress();
                break;
            case LocationAction.ACTION_REQUEST_SUCCESS:
                LocationModel model = store.getLocationModel();
                if (model != null){
                    infoView.setText(model.toString());
                }
                break;
            case LocationAction.ACTION_REQUEST_ERROR:
                break;
        }
    }
}
