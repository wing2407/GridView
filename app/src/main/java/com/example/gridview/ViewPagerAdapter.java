package com.example.gridview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList){
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    /**
     * 得到每个页面
     */
    @Override
    public Fragment getItem(int arg0) {
        return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(arg0);
    }

    /**
     * 每个页面的title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return (titleList.size() > position) ? titleList.get(position) : "";
    }

    /**
     * 页面的总个数
     */
    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }


    //初始化显示的控件，有viewpager和显示导航点的linearlayout
    private void initView(Context context,View v) {
        // 创建imageviews数组，大小是要显示的图片的数量
        imageViews = new ImageView[pageViews.size()];
        // 实例化小圆点的linearLayout和viewpager
        mViewPoints = (LinearLayout) v.findViewById(R.id.viewGroup);
        mViewPager = (ViewPager) v.findViewById(R.id.navigation_page);

        // 添加小圆点的图片
        for (int i = 0; i < pageViews.size(); i++) {
            imageView = new ImageView(context);
            // 设置小圆点imageview的参数
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    10, 10);
            layoutParams.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(layoutParams);// 创建一个宽高均为20 的布局
            // 将小圆点layout添加到数组中
            imageViews[i] = imageView;
            // 默认选中的是第一张图片，此时第一个小圆点是选中状态，其他不是
            if (i == 0) {
                imageViews[i]
                        .setBackgroundResource(R.drawable.indicator_normal_pressed);
            } else {
                imageViews[i]
                        .setBackgroundResource(R.drawable.indicator_normal);
            }

            // 将imageviews添加到小圆点视图组
            mViewPoints.addView(imageViews[i]);
        }
        // 设置viewpager的适配器和监听事件
        mViewPager.setAdapter(new NavigationPageAdapter());
        mViewPager.setOnPageChangeListener(new NavigationPageChangeListener());

    }
    private class NavigationPageAdapter extends PagerAdapter {

        // 销毁position位置的界面
        @Override
        public void destroyItem(View v, int position, Object arg2) {
            ((ViewPager) v).removeView((View) arg2);
        }

        // 获取当前窗体界面数
        @Override
        public int getCount() {
            return pageViews.size();
        }

        // 初始化position位置的界面
        @Override
        public Object instantiateItem(View v, int position) {
            View contentView = pageViews.get(position);
            /**
             *显示页面的相关操作
             **/
            ((ViewPager) v).addView(contentView, 0);
            return pageViews.get(position);
        }

        @Override
        public boolean isViewFromObject(View v, Object arg1) {
            return v == arg1;
        }

        @Override
        public void startUpdate(View arg0) {
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

    }
    //设置viewpager滑动的事件，实现导航点的滚动
    private class NavigationPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[position]
                        .setBackgroundResource(R.drawable.indicator_normal_pressed);
                // 不是当前选中的page，其小圆点设置为未选中的状态
                if (position != i) {
                    imageViews[i]
                            .setBackgroundResource(R.drawable.indicator_normal);
                }
            }
        }
    }

}
