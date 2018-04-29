package com.example.ryzen1400.abd.view.news.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.presenter.home.HomeActivityPresenterImpl;
import com.example.ryzen1400.abd.view.base.BaseActivity;
import com.example.ryzen1400.abd.view.impl.HomeActivityViewImpl;

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
