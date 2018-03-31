package com.example.ryzen1400.abd.utils.leancloud;

import android.view.View;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;
import com.example.ryzen1400.abd.utils.finalObject.LeancloudCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryzen1400 on 2018/3/13.
 */

public class LeanCloudUtils {
    boolean succed=true;
    List<AVObject> list=new ArrayList<>();
    private  static  LeanCloudUtils instance;
    public  static LeanCloudUtils getInstance(){
        if (instance==null)
            instance=new LeanCloudUtils();
         return  instance;
    }

    public   boolean input(AVObject avObject){
      /*  AVObject avObject = new AVObject("Product");
        avObject.put("title", "asd");
        avObject.put("description", "asd");
        avObject.put("price", "asd");
        avObject.put("owner", "asd");
        avObject.put("image", "asd");*/
        succed=true;
        avObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    succed=true;
                } else {
                    succed=false;
                }
            }
        });
        return succed;
    }

    public  void   getTable(AVQuery avQuery, final LeancloudCallBack callBack){
       /* AVQuery<AVObject> avQuery = new AVQuery<>("Product");
        avQuery.orderByDescending("createdAt");
       avQuery.whereMatches("title","asd");*/
        succed=true;
        list.clear();
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> response, AVException e) {
                if (e == null) {
                  list=response;
                    callBack.onSucced(list);
                } else {
                }
            }
        });
    }
}
