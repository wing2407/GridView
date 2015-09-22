package com.example.gridview;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    /** 页面list **/
    List<Fragment> fragmentList = new ArrayList<Fragment>();
    /** 页面title list **/
    List<String>   titleList    = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager)findViewById(R.id.viewpager);
        fragmentList.add(new ViewPagerFragment("页面1"));
        fragmentList.add(new ViewPagerFragment("页面2"));
        fragmentList.add(new ViewPagerFragment("页面3"));
        titleList.add("1");
        titleList.add("2");
        titleList.add("3");
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList,titleList));
    }



}
