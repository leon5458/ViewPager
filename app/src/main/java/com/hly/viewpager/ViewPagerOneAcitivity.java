package com.hly.viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/16~~~~~~
 * ~~~~~~更改时间:2018/7/16~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class ViewPagerOneAcitivity extends AppCompatActivity{
    private ViewPager pager;
    /**
     * 每一个界面
     */
    private List<View> views;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpagerone_activity_layout);
        pager = findViewById(R.id.viewpager);
        views = new ArrayList<View>();
        LayoutInflater inflater = getLayoutInflater();
        views.add(inflater.inflate(R.layout.f1,null));
        views.add(inflater.inflate(R.layout.f2,null));
        views.add(inflater.inflate(R.layout.f3,null));
        views.add(inflater.inflate(R.layout.f4,null));
        //需要给ViewPager设置适配器
        PagerAdapter adapter = new PagerAdapter() {

            /**
             * 有多少个切换页
             * @return
             */
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view ==object;
            }
            //对超出范围的资源进行销毁
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                //super.destroyItem(container, position, object);
                container.removeView(views.get(position));
            }
            //对显示的资源进行初始化
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                //return super.instantiateItem(container, position);
                container.addView(views.get(position));
                return views.get(position);
            }
        };
        pager.setAdapter(adapter);
        //给ViewPager添加事件监听
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("WrongConstant")
            @Override
            public void onPageSelected(int arg0) {
                Toast.makeText(ViewPagerOneAcitivity.this, "您选择了："+arg0+"页面", 0).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
