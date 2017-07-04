package com.cliliang.app.ui;

import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cliliang.R;


/**
 * desc: Activity需要引导栏时，以这个类为父类
 * Created by:chenliliang
 * Created on:16/5/4.
 */
public class BaseToolBarActivity extends BaseActivity {
    private TextView titleView;
    private LinearLayout rightLayout;
    private static int[] ATTRS = {
            R.attr.windowActionBarOverlay,
            R.attr.actionBarSize
    };
    @Override
    public void setContentView(int layoutResID) {
        FrameLayout rootLayout = new FrameLayout(this);
        ViewGroup.LayoutParams rootParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootLayout.setLayoutParams(rootParams);

        LayoutInflater inflater = LayoutInflater.from(this);

        View userView = inflater.inflate(layoutResID, null);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0, false);
        /*获取主题中定义的toolbar的高度*/
//        int toolBarSize = (int) typedArray.getDimension(1,(int)getResources().getDimension(R.dimen.abc_action_bar_default_height_material));
        typedArray.recycle();
        /*如果是悬浮状态，则不需要设置间距*/
        int actionBarHeight = getResources().getDimensionPixelSize(R.dimen.actionbar_default_height);
        params.topMargin = overly ? 0 : actionBarHeight;
        rootLayout.addView(userView, params);

        View toolbarRoot = inflater.inflate(R.layout.toolbar_layout, rootLayout);
        Toolbar toolbar = (Toolbar) toolbarRoot.findViewById(R.id.id_tool_bar);
        toolbar.setTitle("");
        titleView = (TextView) toolbarRoot.findViewById(R.id.base_toolbar_title);
        rightLayout = (LinearLayout) toolbarRoot.findViewById(R.id.base_right_icon_layout);
        toolbarRoot.findViewById(R.id.base_navigation_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackClick();
            }
        });

        setContentView(rootLayout);
        setSupportActionBar(toolbar);
    }

    public void setTitle(String title){
        if (titleView != null && !TextUtils.isEmpty(title)){
            titleView.setText(title);
        }
    }

    public void onBackClick(){
        finish();
    }

    public void setRightTextMenu(String menu, View.OnClickListener listener){
        if (rightLayout != null){
            TextView textView = (TextView) getLayoutInflater().inflate(R.layout.common_action_bar_rigth_text_menu_layout, null);
            if (textView != null){
                textView.setText(menu);
                textView.setOnClickListener(listener);
                textView.setTextColor(ContextCompat.getColor(appContext, R.color.colorAccent));
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                rightLayout.addView(textView, lp);
            }
        }
    }

}
