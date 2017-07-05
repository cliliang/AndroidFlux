package com.cliliang.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * desc:
 * Created by:chenliliang
 * Created on:16/5/12.
 */
public final class Util {
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    public static String doubleMoveZero(double number){
        String numberString = String.valueOf(number);
        if(numberString.indexOf(".") > 0){
            //正则表达
            numberString = numberString.replaceAll("0+?$", "");//去掉后面无用的零
            numberString = numberString.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        return numberString;
    }

    //两时间相差几天
    public static int dayFromEnd(long startTime, long endTime){
        int day;
        if (endTime <= startTime){
            day = 0;
        }else {
            day = (int) ((endTime - startTime) / (24 * 60 * 60L * 1000));
        }
        return day;
    }

    public static String getDistanceSec(long timestamp){
        int distanceTimestamp = (int)(timestamp / 1000);
        int hour = (int)(distanceTimestamp / 60f / 60f);
        int min = (int)((distanceTimestamp - hour * 60 * 60) / 60f);
        int sec = (distanceTimestamp - hour * 60 * 60 - min * 60);
        return String.format(Locale.CHINA, "%02d", hour) + ":" + String.format(Locale.CHINA, "%02d", min) + ":" + String.format(Locale.CHINA, "%02d", sec);

    }

    public static double getDingQiPreMoney(float investMoney, int investDay, double process) {
        return investMoney * investDay * process / 100 / 365;
    }

    public static double getHuoQiPrdMoney(double investMoney, double process) {
        double preMoney;
        double interest = 0;
        for (int i = 1; i < 31; i++) {
            preMoney = investMoney * process / 100 / 365;
            interest = interest + preMoney;
            investMoney = investMoney + preMoney;
        }
        return interest;
    }

    public static boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null){
            NetworkInfo networkINfo = cm.getActiveNetworkInfo();
            if (networkINfo != null && networkINfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}
