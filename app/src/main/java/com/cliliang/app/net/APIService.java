package com.cliliang.app.net;


import com.cliliang.user.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * desc: App所有的网络请求都在这里
 * Created by:chenliliang
 * Created on:16/5/6.
 */
public interface APIService {

    @FormUrlEncoded
    @POST(APIClient.getLocation)
    Call<User> getLocation(@FieldMap Map<String, String> map);
}
