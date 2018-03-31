package com.example.ryzen1400.abd.view.home.adapter.fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryzen1400.abd.R;
import com.example.ryzen1400.abd.view.home.activity.HomeActivity;

import java.util.ArrayList;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class PriceFragmentDataVpAdapter extends PagerAdapter {
    LayoutInflater inflater;
    View view0 ;
    View view1;
    View view2;
    View view3;
    View view4;
    ArrayList<View> viewList;
    ArrayList<String> titles;
Context context;
    public PriceFragmentDataVpAdapter(LayoutInflater inflater, Context context, ArrayList<String> titles) {
        this.inflater=inflater;
        this.context=context;
        this.titles=titles;
        view0 = inflater.inflate(R.layout.fragment_price_vp_item, null);
        view1 = inflater.inflate(R.layout.fragment_price_vp_item, null);
        view2 = inflater.inflate(R.layout.fragment_price_vp_item, null);
        view3 = inflater.inflate(R.layout.fragment_price_vp_item, null);
        view4 = inflater.inflate(R.layout.fragment_price_vp_item, null);
        viewList = new ArrayList<>();// 将要分页显示的View装入数组中
        viewList.add(view0);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        initRv();
    }

    void initRv() {
        for (int i=0;i<viewList.size();i++){
            RecyclerView rv=  viewList.get(i).findViewById(R.id.recycleView);
           rv.setLayoutManager(new LinearLayoutManager(context));
           PriceFragmentRvAdapter adapter=new PriceFragmentRvAdapter(i, (HomeActivity) context);
           rv.setAdapter(adapter);
        }
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
        return viewList.get(position);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}

