/*
 * Copyright (c) 2014 Beijing Dnurse Technology Ltd. All rights reserved.
 */

package com.cliliang.app.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.Stack;

public class AppManager {

    private static Stack<WeakReference<Activity>> activityStack;
    private AppManager() {
        activityStack = new Stack<>();
    }

    private static class AppManagerHolder{
        private static final AppManager instance = new AppManager();
    }

    public static AppManager getInstance(){
        return AppManagerHolder.instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(WeakReference<Activity> activity) {
        activityStack.add(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void removeActivity(WeakReference<Activity> activity) {
        if (activity != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity getTopActivity() {
        Activity activity = activityStack.lastElement().get();
        if (activity == null){
            return null;
        }else {
            return activity;
        }
    }



    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (WeakReference<Activity> weakReference : activityStack) {
            Activity activity = weakReference.get();
            if (activity != null && activity.getClass().equals(cls)) {
                activityStack.remove(weakReference);
                activity.finish();
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            Activity act = activityStack.pop().get();
            if (null != act) {
                act.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void appExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}