package com.example.ryzen1400.abd.view.home.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ryzen1400.abd.presenter.home.PriceFragmentPresenterImpl;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.utils.screen.ScreenCalculater;
import com.example.ryzen1400.abd.view.base.BaseFragment;
import com.example.ryzen1400.abd.view.home.activity.HomeActivity;
import com.example.ryzen1400.abd.view.home.adapter.fragment.PriceFragmentDataVpAdapter;
import com.example.ryzen1400.abd.view.home.adapter.fragment.PriceFragmentTopVpAdapter;
import com.example.ryzen1400.abd.view.impl.PriceFragmentViewImpl;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class PriceFragment extends BaseFragment<PriceFragmentPresenterImpl> implements PriceFragmentViewImpl {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabs)
    TabLayout tablayout;
    @BindView(R.id.topVp)
    ViewPager topVp;
    @BindView(R.id.dotLl)
    LinearLayout dotLl;
    @BindView(R.id.topVpText)
    TextView topVpText;
    Button   mPreSelectedBt;
    Context application;
    HomeActivity activity;
    int vpPosition=0;
    int i=0;
    Timer  timer ;
    TimerTask  task;

    @Override
    public int setContentView() {
        return R.layout.fragment_price;
    }

    @Override
    public void init() {
        initData();
        initView();

    }

    void initData() {
        activity= (HomeActivity) getActivity();
        presenterImpl.getInitData();
    }

    void initView() {
        initTopVp();
        initDataVp();

    }

    void initTopVp() {
         application=getActivity().getApplication();
        PriceFragmentTopVpAdapter adapter = new PriceFragmentTopVpAdapter(getLayoutInflater(), getActivity());
        topVp.setAdapter(adapter);
        setDotInViewPager();
        topVpText.setText("广东省主要农产品零售价格微幅波动");
        topVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 setTopVpText(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initDotMoveThread();
    }

    void setTopVpText(int vpPosition){
          if (vpPosition==0)
              topVpText.setText("广东省主要农产品零售价格微幅波动");
        if (vpPosition==1)
            topVpText.setText("广东省生猪出场价格升幅收窄");
        if (vpPosition==2)
            topVpText.setText("广东省主要农产品零售价格基本稳定");

    }
    public void setDotInViewPager(){
        dotLl.removeAllViews();
        for (int i = 0; i <3; i++) {
            Button bt = new Button(activity);
            LinearLayout.LayoutParams  layoutParams  =new LinearLayout.LayoutParams(ScreenCalculater.DpToPx(activity,8),ScreenCalculater.DpToPx(activity,8));
            layoutParams.setMargins(ScreenCalculater.DpToPx(activity,3),0,0,0);
            bt.setLayoutParams(layoutParams);
            bt.setBackgroundResource(R.drawable.white_dot);
            dotLl.addView(bt);
        }
        topVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(mPreSelectedBt != null){
                    mPreSelectedBt.setBackgroundResource(R.drawable.white_dot);
                }


                if (dotLl.getChildCount()!=0)
                { Button currentBt = (Button)dotLl.getChildAt(position);
                    currentBt.setBackgroundResource(R.drawable.blue_dot);
                    mPreSelectedBt = currentBt;}

            }

            @Override
            public void onPageSelected(int position) {
                vpPosition=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    void initDotMoveThread(){
          timer = new Timer();
          task=new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        topVp.setCurrentItem(i);
                    }
                });
                if (i==2){
                    i=0;
                }else {
                    i++;
                }
            }
        };
        timer.schedule(task, 2000,2000);

    }

    void initDataVp() {
        ArrayList<String> titles=new ArrayList<>();
        titles.add("粮食"); titles.add("蔬菜"); titles.add("畜类");    titles.add("禽类");
          titles.add("蛋类");
        PriceFragmentDataVpAdapter adapter = new PriceFragmentDataVpAdapter(getLayoutInflater(), getActivity(),     titles);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabsFromPagerAdapter(adapter);

    }

    @Override
    public PriceFragmentPresenterImpl initPresenter() {
        return new PriceFragmentPresenterImpl(this);
    }

    @Override
    public void OnDestroy() {
      if (timer!=null)
          timer.cancel();
      timer=null;
    }

    @Override
    public void onRefresh(Object... parms) {

    }



}
