package com.example.ryzen1400.abd.model.base;

import com.example.ryzen1400.abd.model.bean.PriceItem;
import com.example.ryzen1400.abd.utils.mNetWork.NetWorkUtils;
import com.example.ryzen1400.abd.utils.mNetWork.mHttpResult.DefaultHttpResult;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class MarketFragmentModel extends BaseModel {
    public void getFragmentItemData(final BaseLoadFinishListener baseLoadFinishListener){
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
                .compose(new Observable.Transformer<String, DefaultHttpResult<PriceItem>>(){
                    @Override
                    public Observable<DefaultHttpResult<PriceItem>> call(Observable<String> stringObservable) {

                        return NetWorkUtils.getNetWorkApi().getPriceFragmentData()
                                .subscribeOn(Schedulers.io())//请求完成后在ui线程中执行
                                .observeOn(AndroidSchedulers.mainThread());//请求在io线程中执行
                    }
                })
                .subscribe(new Subscriber<DefaultHttpResult<PriceItem>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DefaultHttpResult<PriceItem> postDefaultHttpResult) {
                        baseLoadFinishListener.loadSucced(postDefaultHttpResult);
                    }
                });
    }
}
