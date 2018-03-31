package com.example.ryzen1400.abd.view.home.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.ryzen1400.abd.presenter.home.MessageFragmentPresenterImpl;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.view.base.BaseFragment;
import com.example.ryzen1400.abd.view.home.adapter.fragment.MessageFragmentRvAdapter;
import com.example.ryzen1400.abd.view.impl.MessageFragmentViewImpl;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class MessageFragment extends BaseFragment<MessageFragmentPresenterImpl> implements MessageFragmentViewImpl {
    @BindView(R.id.rv)
    RecyclerView rv;

    Context context;


    @Override
    public int setContentView() {
        return R.layout.fragment_message;
    }

    @Override
    public void init() {
        initData();
        initView();
    }

    void initData() {
        presenterImpl.getInitData();
    }

    void initView() {

       initRl();
    }

   void initRl(){

       //设置并列2行的layoutManager
       rv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
       //设置adapter
       MessageFragmentRvAdapter adapter=new MessageFragmentRvAdapter(getActivity().getApplicationContext());
       AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
       alphaAdapter.setDuration(2000);
      // alphaAdapter.setInterpolator(new OvershootInterpolator());
       ScaleInAnimationAdapter scaleInAnimationAdapter=     new ScaleInAnimationAdapter(alphaAdapter);
       scaleInAnimationAdapter.setDuration(600);
       scaleInAnimationAdapter.setFirstOnly(false);
       rv.setAdapter(scaleInAnimationAdapter);

    }


    @Override
    public MessageFragmentPresenterImpl initPresenter() {
        return new MessageFragmentPresenterImpl(this);
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public void onRefresh(Object... parms) {

    }





}
