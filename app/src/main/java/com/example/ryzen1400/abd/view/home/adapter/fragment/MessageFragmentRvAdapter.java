package com.example.ryzen1400.abd.view.home.adapter.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.view.news.activity.NewsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class MessageFragmentRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   public List<AVObject> data=new ArrayList<>();
    Context context;
   public MessageFragmentRvAdapter(Context context){

        this.context=context;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View v= LayoutInflater.from(context).inflate(R.layout.fragment_message_rv_item,parent,false);
        return new RecycleItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecycleItemViewHolder mholder= (RecycleItemViewHolder) holder;
       setData(mholder,position);
    }

    void setData(RecycleItemViewHolder mholder, final int i){
      mholder.titleText.setText(data.get(i).getString("title"));
        mholder.dateText.setText("发布时间 : "+data.get(i).getString("date"));
        Glide.with(context)
                .load(data.get(i).getString("url"))
                .into(mholder.iv);
        mholder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,NewsActivity.class);
                intent.putExtra("url",data.get(i).getString("url"));
                intent.putExtra("title",data.get(i).getString("title"));
                intent.putExtra("content","      "+data.get(i).getString("content"));
                context.startActivity(intent);
            }
        });
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
        @BindView(R.id.textView)
        TextView dateText;
        @BindView(R.id.cl)
        ConstraintLayout cl;

        public  RecycleItemViewHolder(View parent){
            super(parent);
            ButterKnife.bind(this, parent);

        }
    }
}
