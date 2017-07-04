package com.cliliang.app.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import com.cliliang.app.AppContext;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/4.
 */

public class CrashHandler  implements Thread.UncaughtExceptionHandler{
    private final String TAG = "CrashHandler";
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private CrashHandler(){
        defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Log.i(TAG, "getDefaultException");
    }

    private static class CrashHandlerHolder{
        private static final CrashHandler instance = new CrashHandler();
    }

    public static CrashHandler getInstance(){
        return CrashHandlerHolder.instance;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (!processException(e) && defaultExceptionHandler != null){
            defaultExceptionHandler.uncaughtException(t, e);
        }else {
            //退出程序
            AppManager.getInstance().appExit();
        }
    }

    private boolean processException(Throwable e){
        if (e == null){
            return false;
        }
        Log.d(TAG, getExceptionInfo(e));
        return true;
    }

    private String getExceptionInfo(Throwable throwable){
        if (throwable == null){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        try {
            AppContext appContext = AppContext.getInstance();
            PackageManager packageManager = appContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(appContext.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (packageInfo != null){
                builder.append("============APK===========");
                builder.append("\n");
                builder.append("VersionCode:");
                builder.append(packageInfo.versionCode);
                builder.append("\n");
                builder.append("VersionName:");
                builder.append(packageInfo.versionName);
                builder.append("\n");
            }
        }catch (PackageManager.NameNotFoundException e){
            Log.i(TAG, e.getMessage());
        }

        builder.append("============Device===========");
        builder.append("\n");
        builder.append("手机品牌：");
        builder.append(Build.BRAND);
        builder.append("\n");
        builder.append("制造商：");
        builder.append(Build.MANUFACTURER);
        builder.append("\n");
        builder.append("手机型号：");
        builder.append(Build.MODEL);
        builder.append("\n");

        builder.append("============Exception===========");
        builder.append("\n");
        builder.append("Exception:")
                .append(throwable.getMessage())
                .append("\n");
        StackTraceElement elements[] = throwable.getStackTrace();
        for (StackTraceElement element : elements){
            builder.append(element.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
