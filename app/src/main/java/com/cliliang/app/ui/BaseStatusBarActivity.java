package com.cliliang.app.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * desc: 界面里状态栏为透明
 * Created by:chenliliang
 * Created on:16/5/4.
 */
public class BaseStatusBarActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 全透明实现
            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.setStatusBarColor(Color.TRANSPARENT);

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
//
//    protected int getStatusBarHeight(){
////        int height = 0;
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
////            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
////            if (resourceId > 0) {
////                height = getResources().getDimensionPixelSize(resourceId);
////            }
////        }
//
//        int statusBarHeight2 = -1;
//        try {
//            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
//            Object object = clazz.newInstance();
//            int height = Integer.parseInt(clazz.getField("status_bar_height")
//                    .get(object).toString());
//            statusBarHeight2 = getResources().getDimensionPixelSize(height);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return statusBarHeight2;
//    }
}
