package com.example.ryzen1400.abd.view.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.ryzen1400.abd.presenter.home.UpFragmentPresenterImpl;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.view.base.BaseFragment;
import com.example.ryzen1400.abd.view.home.activity.PriceAnalysis;
import com.example.ryzen1400.abd.view.home.adapter.fragment.UpFragmentDataVpAdapter;
import com.example.ryzen1400.abd.view.impl.UpFragmentViewImpl;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class UpFragment extends BaseFragment<UpFragmentPresenterImpl> implements UpFragmentViewImpl {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabs)
    TabLayout tablayout;
    @BindView(R.id.toAnalysis)
    Button toAnalysis;
    Context context;
    int vpPosition=0;

    @Override
    public int setContentView() {
        return R.layout.fragment_up;
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
        toAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), PriceAnalysis.class));
            }
        });
        initDataVp();
    }






    void initDataVp() {
        ArrayList<String> titles=new ArrayList<>();
        titles.add("月涨幅"); titles.add("月跌幅");
        UpFragmentDataVpAdapter adapter = new UpFragmentDataVpAdapter(getLayoutInflater(), getActivity(),     titles);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabsFromPagerAdapter(adapter);

    }

    @Override
    public UpFragmentPresenterImpl initPresenter() {
        return new UpFragmentPresenterImpl(this);
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public void onRefresh(Object... parms) {

    }



}
