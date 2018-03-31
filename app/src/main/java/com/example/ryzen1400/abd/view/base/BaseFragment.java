package com.example.ryzen1400.abd.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public abstract class BaseFragment<P> extends Fragment {
   public P presenterImpl;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     view=inflater.inflate(setContentView(),container,false);
     ButterKnife.bind(this, view);
        presenterImpl=initPresenter();
     init();
     return view;
    }
    public abstract int setContentView();
    public abstract void  init();
    public abstract P initPresenter();
    public abstract void  OnDestroy();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenterImpl=null;
        OnDestroy();
    }
}
