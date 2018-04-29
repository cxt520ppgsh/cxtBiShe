package com.example.ryzen1400.abd.view.home.activity;

import android.graphics.Color;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.example.ryzen1400.abd.R;
import com.idtk.smallchart.chart.CombineChart;
import com.idtk.smallchart.chart.LineChart;
import com.idtk.smallchart.data.LineData;
import com.idtk.smallchart.interfaces.iData.ILineData;

import java.util.ArrayList;

public class PriceAnalysis extends AppCompatActivity {
    private LineData mLineData = new LineData();
    private ArrayList<ILineData> mDataList = new ArrayList<>();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();

    protected float[][] points = new float[][]{{7,130.92f}, {8,132.12f}, {9,132.22f}, {10,131.72f}, {11,131.72f},{12,129.82f}};
    protected float[][] points2 = new float[][]{{1,52}, {2,13}, {3,51}, {4,20}, {5,19},{6,20}, {7,54}, {8,7}, {9,19}, {10,41}};
    protected int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    protected float pxTodp(float value){
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float valueDP= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,metrics);
        return valueDP;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_analysis);
        initChart();
    }

    private void initChart(){
        initData();
        LineChart lineChart = (LineChart)findViewById(R.id.lineChart);
        lineChart.isAnimated = false;
        lineChart.setDataList(mDataList);
    }

    private void initData() {
        for (int i = 0; i < points.length; i++) {
            mPointArrayList.add(new PointF(points[i][0], points[i][1]));
        }
        mLineData.setValue(mPointArrayList);
        mLineData.setColor(Color.MAGENTA);
        mLineData.setPaintWidth(pxTodp(3));
        mLineData.setTextSize(pxTodp(10));
        mDataList.add(mLineData);
    }
}
