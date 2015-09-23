package com.example.gridview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {


    ViewPagerAdapter mAdapter;

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setAdapter(mAdapter);

    }
}