package com.example.ryzen1400.abd.presenter.home;

import com.example.ryzen1400.abd.presenter.base.BasePresenter;
import com.example.ryzen1400.abd.model.bean.User;
import com.example.ryzen1400.abd.utils.mNetWork.NetWorkUtils;
import com.example.ryzen1400.abd.utils.mNetWork.mHttpResult.DefaultHttpResult;
import com.example.ryzen1400.abd.view.impl.MessageFragmentViewImpl;

import java.lang.ref.SoftReference;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class MessageFragmentPresenterImpl implements BasePresenter {


    SoftReference<MessageFragmentViewImpl> view;
    public MessageFragmentPresenterImpl(MessageFragmentViewImpl upFragmentViewImpl){
        view = new SoftReference<MessageFragmentViewImpl>(upFragmentViewImpl);
    }

    public   void getInitData(){

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        }).observeOn(Schedulers.io()).subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .compose(new Observable.Transformer<String, DefaultHttpResult<User>>(){
                    @Override
                    public Observable<DefaultHttpResult<User>> call(Observable<String> stringObservable) {

                        return NetWorkUtils.getNetWorkApi().register("postNews","a","a","a","a","a")
                                .subscribeOn(Schedulers.io())//请求完成后在ui线程中执行
                                .observeOn(AndroidSchedulers.mainThread());//请求在io线程中执行
                    }
                })
                .subscribe(new Subscriber<DefaultHttpResult<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DefaultHttpResult<User> postDefaultHttpResult) {

                    }
                });


    }

}
