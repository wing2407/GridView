package com.example.gridview;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    ViewPagerAdapter mAdapter;
    ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LinearLayout group = (LinearLayout) findViewById(R.id.viewGroup);
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this, group, mPager);
        mPager.setAdapter(mAdapter);

    }


}