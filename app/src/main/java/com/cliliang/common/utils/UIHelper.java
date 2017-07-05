package com.cliliang.common.utils;

import android.content.Context;
import android.view.WindowManager;
import android.widget.Toast;

import com.cliliang.app.AppContext;

public final class UIHelper {

    static Toast toast1 = null;
    static Toast toast = null;
    private UIHelper() {
    }

    public static void ToastMessage(String msg) {
        if (toast1 == null) {
            toast1 = Toast.makeText(AppContext.getInstance(), msg, Toast.LENGTH_LONG);
        } else {
            toast1.setText(msg);
        }
        toast1.show();
    }

    public static void ToastMessage(int msg) {
        if (toast == null) {
            toast = Toast.makeText(AppContext.getInstance(), AppContext.getInstance().getResources().getString(msg), Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public static int[] getScreenDisplay() {
        WindowManager windowManager = (WindowManager) AppContext.getInstance().getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        int result[] = { width, height };
        return result;
    }
}
