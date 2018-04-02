package com.example.ryzen1400.abd.view.home.adapter.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.utils.finalObject.FinalObject;
import com.example.ryzen1400.abd.utils.finalObject.LeancloudCallBack;
import com.example.ryzen1400.abd.utils.leancloud.LeanCloudUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class MarketFragmentRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
  public   List<AVObject> data=new ArrayList<>();
   public MarketFragmentRvAdapter(Context context){

        this.context=context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View v= LayoutInflater.from(context).inflate(R.layout.fragment_market_rv_item,parent,false);
        return new RecycleItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecycleItemViewHolder mholder= (RecycleItemViewHolder) holder;
       setData(mholder,position);
    }

    void setData(RecycleItemViewHolder mholder,int position){
        mholder.titleText.setText(data.get(position).getString("name"));
        Glide.with(context)
                .load(data.get(position).getString("url"))
                .into(mholder.iv);

   }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class RecycleItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.titleText)
        TextView titleText;

        public  RecycleItemViewHolder(View parent){
            super(parent);
            ButterKnife.bind(this, parent);

        }
    }
}
