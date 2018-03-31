package com.example.ryzen1400.abd.view.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.example.ryzen1400.abd.presenter.home.HomeActivityPresenterImpl;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.view.base.BaseActivity;
import com.example.ryzen1400.abd.view.home.adapter.activity.HomeVpFragmentAdapter;
import com.example.ryzen1400.abd.view.home.fragment.MarketFragment;
import com.example.ryzen1400.abd.view.home.fragment.MessageFragment;
import com.example.ryzen1400.abd.view.home.fragment.PriceFragment;
import com.example.ryzen1400.abd.view.home.fragment.UpFragment;
import com.example.ryzen1400.abd.view.impl.HomeActivityViewImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<HomeActivityPresenterImpl> implements HomeActivityViewImpl {


    @BindView(R.id.home_vp)
   public ViewPager home_vp;

    @BindView(R.id.home_bottombar)
    LinearLayout home_bottombar;

    @BindView(R.id.price_rl)
    RelativeLayout price_rl;
    @BindView(R.id.up_rl)
    RelativeLayout up_rl;
    @BindView(R.id.market_rl)
    RelativeLayout market_rl;
    @BindView(R.id.message_rl)
    RelativeLayout message_rl;

    @BindView(R.id.price_bt)
    Button price_bt;
    @BindView(R.id.up_bt)
    Button up_bt;
    @BindView(R.id.market_bt)
    Button market_bt;
    @BindView(R.id.message_bt)
    Button message_bt;

    @BindView(R.id.price_text)
    TextView price_text;
    @BindView(R.id.up_text)
    TextView up_text;
    @BindView(R.id.market_text)
    TextView market_text;
    @BindView(R.id.message_text)
    TextView message_text;


    List<Fragment> homeFragmentList;
    List<RelativeLayout> bottomBarRlList;
    List<Button> bottomBarButtonList;
    List<TextView> bottomBarTextList;
    @Override
    public int setContentView() {
        return R.layout.activity_home_drawer;
    }


    @Override
    public HomeActivityPresenterImpl initPresenter() {
        return new HomeActivityPresenterImpl();
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public void init() {
      initVp();
      initBottomBar();

        // 测试 SDK 是否正常工作的代码
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    Log.d("saved","success!");
                }
            }
        });
    }

    void initVp(){
        bottomBarRlList=new ArrayList<>();
        bottomBarRlList.add(price_rl);
        bottomBarRlList.add(up_rl);
        bottomBarRlList.add(market_rl);
        bottomBarRlList.add(message_rl);
        homeFragmentList=new ArrayList<>();
        homeFragmentList.add(new PriceFragment());
        homeFragmentList.add(new UpFragment());
        homeFragmentList.add(new MarketFragment());
        homeFragmentList.add(new MessageFragment());
        HomeVpFragmentAdapter adapter=new HomeVpFragmentAdapter(getSupportFragmentManager(),homeFragmentList);
        home_vp.setAdapter(adapter);
        home_vp.setOffscreenPageLimit(3);
        home_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomBarRlList.get(position).callOnClick();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    void initBottomBar(){
        bottomBarButtonList=new ArrayList<>();
        bottomBarButtonList.add(price_bt);
        bottomBarButtonList.add(up_bt);
        bottomBarButtonList.add(market_bt);
        bottomBarButtonList.add(message_bt);

        bottomBarTextList=new ArrayList<>();
        bottomBarTextList.add(price_text);
        bottomBarTextList.add(up_text);
        bottomBarTextList.add(market_text);
        bottomBarTextList.add(message_text);

        price_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_vp.setCurrentItem(0);
              for (Button button:bottomBarButtonList){
                  if (button==price_bt)
                      button.setSelected(true);
                  else button.setSelected(false);
              }
                for (TextView textView:bottomBarTextList){
                    if (textView==price_text)
                        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                    else   textView.setTextColor(getResources().getColor(R.color.textGray));
                }
            }
        });
        up_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_vp.setCurrentItem(1);
                for (Button button:bottomBarButtonList){
                    if (button==up_bt)
                        button.setSelected(true);
                    else button.setSelected(false);
                }
                for (TextView textView:bottomBarTextList){
                    if (textView==up_text)
                        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                    else   textView.setTextColor(getResources().getColor(R.color.textGray));
                }
            }
        });
        market_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_vp.setCurrentItem(2);
                for (Button button:bottomBarButtonList){
                    if (button==market_bt)
                        button.setSelected(true);
                    else button.setSelected(false);
                }
                for (TextView textView:bottomBarTextList){
                    if (textView==market_text)
                        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                    else   textView.setTextColor(getResources().getColor(R.color.textGray));
                }
            }
        });
        message_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_vp.setCurrentItem(3);
                for (Button button:bottomBarButtonList){
                    if (button==message_bt)
                        button.setSelected(true);
                    else button.setSelected(false);
                }
                for (TextView textView:bottomBarTextList){
                    if (textView==message_text)
                        textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                    else   textView.setTextColor(getResources().getColor(R.color.textGray));
                }
            }
        });

        price_rl.callOnClick();
    }


    @Override
    public void onRefresh(Object... parms) {

    }
}
