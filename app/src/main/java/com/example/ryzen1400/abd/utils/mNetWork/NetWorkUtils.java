package com.example.ryzen1400.abd.utils.mNetWork;

import com.example.ryzen1400.abd.utils.mNetWork.mApi.NetWorkApi;
import com.example.ryzen1400.abd.utils.mNetWork.mResponseBodyConverter.ResponseConvertFactory;

import java.util.concurrent.TimeUnit;



import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Longgest Chan on 2017/1/9.
 */

public class NetWorkUtils {
    private static NetWorkApi netWorkApi;
    private static OkHttpClient.Builder builder = new OkHttpClient.Builder();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static final int DEFAULT_TIMEOUT = 30;//超时时间

    public static NetWorkApi getNetWorkApi() {
        if (netWorkApi == null) {
            builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            Retrofit retrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .baseUrl("http://shoubing.gzinterest.com/")
                    .addConverterFactory(ResponseConvertFactory.create())//这里用自定义的Conver进行预处理
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            netWorkApi = retrofit.create(NetWorkApi.class);
        }
        return netWorkApi;
    }


}