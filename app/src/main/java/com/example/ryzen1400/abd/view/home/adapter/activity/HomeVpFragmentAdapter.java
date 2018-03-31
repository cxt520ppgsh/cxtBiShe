package com.example.ryzen1400.abd.view.home.adapter.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by ryzen1400 on 2017/12/25.
 */

public class HomeVpFragmentAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList;
    public  HomeVpFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList=fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
