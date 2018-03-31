package com.example.ryzen1400.abd.init;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ryzen1400 on 2018/3/13.
 */

public  class MApplication extends Application {
   public static ExecutorService fixedThreadPool;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        // 初始化参数依次为 this, AppId, AppKey
    }
void init(){
    initLeancloud();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initThreadPool();
            }
        }).start();
}
void initLeancloud(){
    AVOSCloud.initialize(this,"I4uzXFHNoWX5DVxcMsqJHNks-gzGzoHsz","YcKUd5kRK5JJ67FRGopgNmfD");
}

  void  initThreadPool(){
       fixedThreadPool= Executors.newFixedThreadPool(4);
  }
    public static synchronized  ExecutorService getFixedThreadPool(){
        if (fixedThreadPool == null) {
            fixedThreadPool= Executors.newFixedThreadPool(4);
        }
        return fixedThreadPool;
    }
}