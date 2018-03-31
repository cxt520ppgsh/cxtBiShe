package com.example.ryzen1400.abd.utils.mNetWork.mDownload;

import com.example.ryzen1400.abd.utils.mNetWork.mApi.NetWorkApi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Longgest Chan on 2017/1/12.
 */

public class DownLoadUtils {
    public static Retrofit retrofit;
    private static final int DEFAULT_TIMEOUT = 15;

  public static   void download(String url, final File file){



    /*    DownloadAPI(url, new DownloadProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {

            }
        }).create(NetWorkApi.class)
                .download(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new Func1<ResponseBody, InputStream>() {
                    @Override
                    public InputStream call(ResponseBody responseBody) {
                        return responseBody.byteStream();
                    }
                })
                .observeOn(Schedulers.computation())
                .doOnNext(new Action1<InputStream>() {
                    @Override
                    public void call(InputStream inputStream) {
                        try {
                            FileUtils.writeFile(inputStream, file);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new CustomizeException(e.getMessage(), e);
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<InputStream>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onNext(InputStream inputStream) {

                    }
                });*/
    }


    public static Retrofit  DownloadAPI(String url, DownloadProgressListener listener) {
   if (retrofit!=null) {
       DownloadProgressInterceptor interceptor = new DownloadProgressInterceptor(listener);

       OkHttpClient client = new OkHttpClient.Builder()
               .addInterceptor(interceptor)
               .retryOnConnectionFailure(true)
               .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
               .readTimeout(1000, TimeUnit.MINUTES)
               .writeTimeout(1000, TimeUnit.MINUTES)
               .build();


       retrofit = new Retrofit.Builder()
               .baseUrl(url)
               .client(client)
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               .build();
   }

        return retrofit;
    }
}
