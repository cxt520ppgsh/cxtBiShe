package com.example.ryzen1400.abd.view.news.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.SaveCallback;
import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.presenter.home.HomeActivityPresenterImpl;
import com.example.ryzen1400.abd.utils.finalObject.LeancloudCallBack;
import com.example.ryzen1400.abd.utils.leancloud.LeanCloudUtils;
import com.example.ryzen1400.abd.view.base.BaseActivity;
import com.example.ryzen1400.abd.view.home.adapter.fragment.UpFragmentRvAdapter;
import com.example.ryzen1400.abd.view.impl.HomeActivityViewImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NewsActivity extends BaseActivity<HomeActivityPresenterImpl> implements HomeActivityViewImpl {


    @BindView(R.id.textView2)
   public TextView titletv;
    @BindView(R.id.imageView)
    public ImageView iv;
    @BindView(R.id.content)
    public TextView contenttv;


    @Override
    public int setContentView() {
        return R.layout.activity_news;
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
        String url=getIntent().getStringExtra("url");
        String title=getIntent().getStringExtra("title");
        String content=getIntent().getStringExtra("content");
        titletv.setText(title);
        contenttv.setText(content);
        Glide.with(NewsActivity.this)
                .load(url)
                .into(iv);
    }





    @Override
    public void onRefresh(Object... parms) {

    }
}
