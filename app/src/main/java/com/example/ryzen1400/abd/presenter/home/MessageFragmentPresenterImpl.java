package com.example.ryzen1400.abd.presenter.home;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.example.ryzen1400.abd.presenter.base.BasePresenter;
import com.example.ryzen1400.abd.model.bean.User;
import com.example.ryzen1400.abd.utils.finalObject.LeancloudCallBack;
import com.example.ryzen1400.abd.utils.leancloud.LeanCloudUtils;
import com.example.ryzen1400.abd.utils.mNetWork.NetWorkUtils;
import com.example.ryzen1400.abd.utils.mNetWork.mHttpResult.DefaultHttpResult;
import com.example.ryzen1400.abd.view.home.adapter.fragment.MessageFragmentRvAdapter;
import com.example.ryzen1400.abd.view.impl.MessageFragmentViewImpl;

import java.lang.ref.SoftReference;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class MessageFragmentPresenterImpl implements BasePresenter {


    MessageFragmentViewImpl view;
    public MessageFragmentPresenterImpl(MessageFragmentViewImpl upFragmentViewImpl){
        view = upFragmentViewImpl;
    }

    public   void getInitData(){

    getRvData();

    }

    public void getRvData(){
        AVQuery<AVObject> avQuery = new AVQuery<>("News");

        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {


                view.onRefresh(data);

            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);
    }
}
