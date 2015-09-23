package com.example.gridview;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


class ViewPagerAdapter extends FragmentPagerAdapter {

    static final int NUM_ITEMS = 5;

    Context mContext;
    LinearLayout group;
    ViewPager mViewPager;
    private ImageView[] imageViews;
    private ImageView imageView;

    public ViewPagerAdapter(FragmentManager fm,Context context,LinearLayout group,ViewPager viewPager) {
        super(fm);
        this.mContext =context;
        this.group = group;
        this.mViewPager =viewPager;
        initCirclePoint();
        mViewPager.setOnPageChangeListener(new AdPageChangeListener());

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        return ViewPagerFragment.newInstance(position);
    }

    private void initCirclePoint() {
        imageViews = new ImageView[5];
        //广告栏的小圆点图标
        for (int i = 0; i < 5; i++) {
            //创建一个ImageView, 并设置宽高. 将该对象放入到数组中
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
            imageViews[i] = imageView;

            //初始值, 默认第0个选中
            if (i == 0) {
                imageViews[i]
                        .setBackgroundResource(android.R.drawable.radiobutton_on_background);
            } else {
                imageViews[i]
                        .setBackgroundResource(android.R.drawable.radiobutton_off_background);
            }
            //将小圆点放入到布局中
            group.addView(imageViews[i]);
        }
    }

    /**
     * ViewPager 页面改变监听器
     */
    private final class AdPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 页面滚动状态发生改变的时候触发
         */
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        /**
         * 页面滚动的时候触发
         */
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        /**
         * 页面选中的时候触发
         */
        @Override
        public void onPageSelected(int arg0) {
            //获取当前显示的页面是哪个页面
            //atomicInteger.getAndSet(arg0);
            //重新设置原点布局集合
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0]
                        .setBackgroundResource(android.R.drawable.radiobutton_on_background);
                if (arg0 != i) {
                    imageViews[i]
                            .setBackgroundResource(android.R.drawable.radiobutton_off_background);
                }
            }
        }
    }
}
