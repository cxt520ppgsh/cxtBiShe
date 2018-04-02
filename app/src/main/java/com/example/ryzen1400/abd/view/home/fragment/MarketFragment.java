package com.example.ryzen1400.abd.view.home.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.avos.avoscloud.AVObject;
import com.example.ryzen1400.abd.presenter.home.MarketFragmentPresenterImpl;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.view.base.BaseFragment;
import com.example.ryzen1400.abd.view.home.adapter.fragment.MarketFragmentRvAdapter;
import com.example.ryzen1400.abd.view.impl.MarketFragmentViewImpl;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import  com.example.ryzen1400.abd.model.base.BaseLoadFinishListener;

import java.util.List;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class MarketFragment extends BaseFragment<MarketFragmentPresenterImpl> implements MarketFragmentViewImpl {
    @BindView(R.id.rv)
    RecyclerView rv;
    MarketFragmentRvAdapter adapter;
    Context context;


    @Override
    public int setContentView() {
        return R.layout.fragment_market;
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
       rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
       //设置adapter
        adapter=new MarketFragmentRvAdapter(getActivity().getApplicationContext());
       AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
       alphaAdapter.setDuration(2000);
      // alphaAdapter.setInterpolator(new OvershootInterpolator());
       ScaleInAnimationAdapter scaleInAnimationAdapter=     new ScaleInAnimationAdapter(alphaAdapter);
       scaleInAnimationAdapter.setDuration(600);
       scaleInAnimationAdapter.setFirstOnly(false);
       rv.setAdapter(scaleInAnimationAdapter);

    }


    @Override
    public MarketFragmentPresenterImpl initPresenter() {
        return new MarketFragmentPresenterImpl(this);
    }

    @Override
    public void OnDestroy() {

    }





    @Override
    public void onRefresh(Object... parms) {
        adapter.data= (List<AVObject>) parms[0];
        adapter.notifyDataSetChanged();
    }
}
