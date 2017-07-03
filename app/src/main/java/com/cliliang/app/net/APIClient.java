package com.cliliang.app.net;

import com.cliliang.app.config.AppConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * desc: 网络框架采用retrofit
 * Created by:chenliliang
 * Created on:16/5/6.
 */
public class APIClient {
    protected static final String HTTP = "http://";
    private static final String HTTPS = "https://";

    protected static String getRequestType() {
        return HTTPS;
    }

    protected static final String DEBUG_HOST_BASE = "";
    protected static final String RELEASE_HOST_BASE = "";

    private static final String debugBaseHost = getRequestType() + DEBUG_HOST_BASE;
    private static final String releaseBaseHost = getRequestType() + RELEASE_HOST_BASE;

    private static APIService apiService;

    public static APIService getInstance() {
        if (apiService == null) {
            synchronized (APIClient.class) {
                if (apiService == null){
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(false)
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(getURL())
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    apiService = retrofit.create(APIService.class);
                }
            }
        }
        return apiService;
    }

    private static String getURL() {
        return AppConfig.isDebugVersion ? debugBaseHost : releaseBaseHost;
    }

}
