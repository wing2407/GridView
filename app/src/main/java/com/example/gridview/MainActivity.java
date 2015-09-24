package com.example.gridview;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPagerAdapter mAdapter;
    ViewPager mPager;
    List<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LinearLayout group = (LinearLayout) findViewById(R.id.viewGroup);
        mPager = (ViewPager) findViewById(R.id.viewpager);
        data = initData();
        //这里传入参数比较多，目的让Activity的操作代码尽量简洁
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this, group, mPager, data);
        mPager.setAdapter(mAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();


    }



    private List<String> initData() {
        List<String> init = new ArrayList<String>();
        for (int i = 0; i < 86; i++) {
            init.add("" + i);
        }
        return init;
    }
}