package com.example.ryzen1400.abd.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public abstract class BaseActivity<P> extends AppCompatActivity   {
  public   P presenterImpl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        ButterKnife.bind(this);
        presenterImpl=initPresenter();
        init();
    }
    public abstract int setContentView();
    public abstract void init();
    public abstract P initPresenter();
    public abstract void OnDestroy();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OnDestroy();
        presenterImpl=null;
    }
}
