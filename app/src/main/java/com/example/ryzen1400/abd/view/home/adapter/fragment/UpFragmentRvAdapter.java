package com.example.ryzen1400.abd.view.home.adapter.fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.utils.finalObject.FinalObject;
import com.example.ryzen1400.abd.utils.finalObject.LeancloudCallBack;
import com.example.ryzen1400.abd.utils.leancloud.LeanCloudUtils;
import com.example.ryzen1400.abd.view.home.activity.HomeActivity;
import com.example.ryzen1400.abd.view.home.fragment.UpFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class UpFragmentRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int upOrDown;
    HomeActivity context;
    public List<AVObject> upList= new ArrayList<>();
    public List<AVObject> downList = new ArrayList<>();

   public UpFragmentRvAdapter(Context context,int upOrDown){
        this.upOrDown=upOrDown;
        this.context= (HomeActivity) context;
        setUpFragmentFragmentRvData();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View v= LayoutInflater.from(context).inflate(R.layout.fragment_up_rv_item,parent,false);
        return new RecycleItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecycleItemViewHolder mholder= (RecycleItemViewHolder) holder;
       setData(mholder,position);
    }

    void setData(RecycleItemViewHolder mholder,int i){


        if (upOrDown== FinalObject.UP){
            mholder.typeText.setText(upList.get(i).getString("name"));
            mholder.sizeText.setText(upList.get(i).getString("upDown"));
            mholder.priceText.setText(upList.get(i).getString("grade"));
            mholder.upText.setText(upList.get(i).getString("price"));
            mholder.upText.setTextColor(context.getResources().getColor(R.color.colorAccent));}
        if (upOrDown== FinalObject.DOWN)
        {
            mholder.typeText.setText(downList.get(i).getString("name"));
            mholder.sizeText.setText(downList.get(i).getString("upDown"));
            mholder.priceText.setText(downList.get(i).getString("grade"));
            mholder.upText.setText(downList.get(i).getString("price"));
            mholder.upText.setTextColor(context.getResources().getColor(R.color.colorPrimary));}
        if (i%2==0)
            mholder.Ll.setBackgroundColor(context.getResources().getColor(R.color.white));
        else
            mholder.Ll.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryLight));
   }


    @Override
    public int getItemCount() {
        if (upOrDown==FinalObject.UP)
        return upList.size();
        else return downList.size();

    }
    void setUpFragmentFragmentRvData(){

        AVQuery<AVObject> avQuery = new AVQuery<>("MonthUpDown");

        LeancloudCallBack callback=new LeancloudCallBack() {
            @Override
            public void onSucced(final List<AVObject> data) {
                for (int i=0;i<data.size();i++){
                    if (data.get(i).getString("price").contains("+"))
                        upList.add(data.get(i));
                    else
                        downList.add(data.get(i));
                }
                UpFragmentRvAdapter.this.notifyDataSetChanged();



            }
        };
        LeanCloudUtils.getInstance().getTable(avQuery,callback);


    }

    class RecycleItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.Ll)
        LinearLayout Ll;
        @BindView(R.id.typeText)
        TextView typeText;
        @BindView(R.id.sizeText)
        TextView sizeText;
        @BindView(R.id.priceText)
        TextView priceText;
        @BindView(R.id.upText)
        TextView upText;
        public  RecycleItemViewHolder(View parent){
            super(parent);
            ButterKnife.bind(this, parent);

        }
    }
}
