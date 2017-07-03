package com.cliliang.common.views;

import android.content.Context;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioGroup;

import com.cliliang.R;


/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/5/16.
 */

public class BottomNavigation extends RadioGroup {
    private OnBottomTabCheckedListener listener;
    public BottomNavigation(Context context) {
        super(context);
        init(context);
    }

    public BottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.bottom_navigation_view_layout, this);
        RadioGroup group = (RadioGroup) findViewById(R.id.bottom_navigation_group);
        group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (listener != null){
                    switch (checkedId){
                        case R.id.bottom_navigation_tab1:
                            listener.onBottomTabChecked(0);
                            break;
                        case R.id.bottom_navigation_tab2:
                            listener.onBottomTabChecked(1);
                            break;
                        case R.id.bottom_navigation_tab4:
                            listener.onBottomTabChecked(2);
                            break;
                        case R.id.bottom_navigation_tab5:
                            listener.onBottomTabChecked(3);
                            break;
                    }
                }
            }
        });
    }

    public interface OnBottomTabCheckedListener{
        void onBottomTabChecked(int position);
    }

    public void setOnBottomTabCheckedListener(OnBottomTabCheckedListener l){
        this.listener = l;
    }
}
