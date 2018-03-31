package com.example.ryzen1400.abd.view.home.adapter.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.utils.finalObject.LeancloudCallBack;
import com.example.ryzen1400.abd.utils.leancloud.LeanCloudUtils;
import com.example.ryzen1400.abd.view.home.activity.HomeActivity;
import com.example.ryzen1400.abd.view.home.fragment.PriceFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class PriceFragmentRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int type=0;
    HomeActivity context;
    PriceFragmentRvAdapter (int type,  HomeActivity context){
        this.type=type;
        this.context=context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View v= LayoutInflater.from(context).inflate(R.layout.fragment_price_rv_item,parent,false);
        return new RecycleItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecycleItemViewHolder mholder= (RecycleItemViewHolder) holder;
        if (type==0)
            setPriceFragmentRvData0(mholder,position);
       else if (type==1)
            setPriceFragmentRvData1(mholder,position);
        else   if (type==2)
            setPriceFragmentRvData2(mholder,position);
        else  if (type==3)
            setPriceFragmentRvData3(mholder,position);
        else
            setPriceFragmentRvData4(mholder,position);

       // mholder.tv.setText("丢");
    }


    @Override
    public int getItemCount() {
        if (type==0)
        return 6;
       else if (type==1)
            return 8;
       else if (type==2)
            return 7;
       else if (type==3)
            return 2;
       else
            return 4;
    }


    class RecycleItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv)
        ImageView icon;
        @BindView(R.id.clolo2)
        TextView name;
        @BindView(R.id.clolo)
        TextView price;
        @BindView(R.id.textView5)
        TextView grade;
        @BindView(R.id.textView4)
                TextView date;
        public  RecycleItemViewHolder(View parent){
            super(parent);
            ButterKnife.bind(this, parent);

        }
    }


    void setPriceFragmentRvData0(final RecycleItemViewHolder mholder, final int i){
        AVQuery<AVObject> avQuery = new AVQuery<>("PriceFragment0");
        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(context)
                                .load(data.get(i).getString("url"))
                                .into(mholder.icon);
                      mholder.name.setText(data.get(i).getString("name"));
                        mholder.date.setText(data.get(i).getString("date"));
                        mholder.grade.setText(data.get(i).getString("grade"));
                        mholder.price.setText(data.get(i).getString("price"));
                    }
                });

            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);


    }
    void setPriceFragmentRvData1(final RecycleItemViewHolder mholder, final int i){
        AVQuery<AVObject> avQuery = new AVQuery<>("PriceFragment1");
        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(context)
                                .load(data.get(i).getString("url"))
                                .into(mholder.icon);
                        mholder.name.setText(data.get(i).getString("name"));
                        mholder.date.setText(data.get(i).getString("date"));
                        mholder.grade.setText(data.get(i).getString("grade"));
                        mholder.price.setText(data.get(i).getString("price"));
                    }
                });

            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);


    }
    void setPriceFragmentRvData2(final RecycleItemViewHolder mholder, final int i){
        AVQuery<AVObject> avQuery = new AVQuery<>("PriceFragment2");
        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(context)
                                .load(data.get(i).getString("url"))
                                .into(mholder.icon);
                        mholder.name.setText(data.get(i).getString("name"));
                        mholder.date.setText(data.get(i).getString("date"));
                        mholder.grade.setText(data.get(i).getString("grade"));
                        mholder.price.setText(data.get(i).getString("price"));
                    }
                });

            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);


    }
    void setPriceFragmentRvData3(final RecycleItemViewHolder mholder, final int i){
        AVQuery<AVObject> avQuery = new AVQuery<>("PriceFragment3");
        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(context)
                                .load(data.get(i).getString("url"))
                                .into(mholder.icon);
                        mholder.name.setText(data.get(i).getString("name"));
                        mholder.date.setText(data.get(i).getString("date"));
                        mholder.grade.setText(data.get(i).getString("grade"));
                        mholder.price.setText(data.get(i).getString("price"));
                    }
                });

            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);


    }
    void setPriceFragmentRvData4(final RecycleItemViewHolder mholder, final int i){
        AVQuery<AVObject> avQuery = new AVQuery<>("PriceFragment4");
        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(context)
                                .load(data.get(i).getString("url"))
                                .into(mholder.icon);
                        mholder.name.setText(data.get(i).getString("name"));
                        mholder.date.setText(data.get(i).getString("date"));
                        mholder.grade.setText(data.get(i).getString("grade"));
                        mholder.price.setText(data.get(i).getString("price"));
                    }
                });

            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);


    }
}
