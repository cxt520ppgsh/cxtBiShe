package com.example.ryzen1400.abd.utils.screen;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class ScreenCalculater {
    public static int DpToPx(Context context,float dp){
        float scale=context.getResources().getDisplayMetrics().density;
        int px= (int) (dp*scale+0.5f);
        return px;
    }
    public static int PxToDp(Context context,float px){
        float scale=context.getResources().getDisplayMetrics().density;
        int dp= (int) (px/scale+0.5f);
        return dp;
    }

    public static int getScreenW(Context context){
        Activity activity= (Activity) context;
        DisplayMetrics displayMetrics=new DisplayMetrics();
       activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.widthPixels;
        return screenWidth;

    }


    public static int getScreenH(Context context){
        Activity activity= (Activity) context;
        DisplayMetrics displayMetrics=new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth=displayMetrics.heightPixels;
        return screenWidth;

    }

}
