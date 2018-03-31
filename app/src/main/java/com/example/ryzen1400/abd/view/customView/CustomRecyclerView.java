package com.example.ryzen1400.abd.view.customView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by ryzen1400 on 2017/12/27.
 */

public class CustomRecyclerView extends RecyclerView {
    private double scale;               //抛掷速度的缩放因子

    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setflingScale(double scale){
        this.scale = scale;
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        velocityY *= scale;
        return super.fling(velocityX, velocityY);
    }
}


