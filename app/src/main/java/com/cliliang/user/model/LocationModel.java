package com.cliliang.user.model;

import com.cliliang.app.model.BaseModel;

/**
 * desc:
 * Created by:chenliliang
 * Created on:2017/7/3.
 */

public class LocationModel extends BaseModel {
    private float lon;
    private int level;
    private String address;
    private String cityName;
    private int alevel;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getAlevel() {
        return alevel;
    }

    public void setAlevel(int alevel) {
        this.alevel = alevel;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("经度：").append(String.valueOf(lon)).append("\n")
                .append("纬度：").append(String.valueOf(lat));
        return builder.toString();
    }
}
