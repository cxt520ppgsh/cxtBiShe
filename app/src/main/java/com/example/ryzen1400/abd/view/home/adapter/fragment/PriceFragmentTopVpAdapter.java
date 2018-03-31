package com.example.ryzen1400.abd.view.home.adapter.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ryzen1400.abd.R;

import java.util.ArrayList;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class PriceFragmentTopVpAdapter extends PagerAdapter {
    LayoutInflater inflater;
    View view0 ;
    View view1;
    View view2;
    ArrayList<View> viewList;


Context context;
    public PriceFragmentTopVpAdapter(LayoutInflater inflater, Context context) {
        this.inflater=inflater;
        this.context=context;

        view0 = inflater.inflate(R.layout.fragment_price_top_vp_item, null);
        view1 = inflater.inflate(R.layout.fragment_price_top_vp_item, null);
        view2 = inflater.inflate(R.layout.fragment_price_top_vp_item, null);

        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view0);
        viewList.add(view1);
        viewList.add(view2);

    }




    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        // TODO Auto-generated method stub

        container.removeView(viewList.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        try{
if(viewList.get(position).getParent()==null){
    container.addView(viewList.get(position));
}else{
                ((ViewGroup)viewList.get(position).getParent()).removeView(viewList.get(position));
                container.addView(viewList.get(position));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        initIv(position,viewList);
        return viewList.get(position);

    }



    void initIv(int position, ArrayList<View> viewList){
        if (position==0)
        {   String url = "http://lc-i4uzxfhn.cn-n1.lcfile.com/6eec8226e0fd56d4e296.jpg";
            Glide.with(context)
                    .load(url)
                    .into((ImageView) viewList.get(position).findViewById(R.id.iv));}
        if (position==1)
        {   String url = "http://lc-i4uzxfhn.cn-n1.lcfile.com/4ce97209ba32d6f81d97.jpg";
            Glide.with(context)
                    .load(url)
                    .into((ImageView) viewList.get(position).findViewById(R.id.iv));}
        if (position==2)
        {   String url = "http://lc-i4uzxfhn.cn-n1.lcfile.com/d92e6e31ea061314c615.jpg";
            Glide.with(context)
                    .load(url)
                    .into((ImageView) viewList.get(position).findViewById(R.id.iv));}

    }

}

