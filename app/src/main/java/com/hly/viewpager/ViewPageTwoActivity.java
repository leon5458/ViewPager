package com.hly.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/16~~~~~~
 * ~~~~~~更改时间:2018/7/16~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class ViewPageTwoActivity extends AppCompatActivity {
    private ViewPager pager;
    //每一个界面
    private List<View> views;
    //标题
    private String[] titles = {"新闻", "娱乐", "军事", "随谈"};

    private PagerTabStrip t;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpagertwo_activity_layout);

        t = findViewById(R.id.title);
        //自定义table的样式
        t.setBackgroundColor(Color.MAGENTA);
        t.setTextColor(Color.BLUE);
        t.setTextSize(0, 25f);
        t.setTabIndicatorColor(Color.GREEN);

        pager = findViewById(R.id.pager);
        views = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        views.add(li.inflate(R.layout.f1, null));
        views.add(li.inflate(R.layout.f2, null));
        views.add(li.inflate(R.layout.f3, null));
        views.add(li.inflate(R.layout.f4, null));
        //需要给ViewPager设置适配器
        PagerAdapter adapter = new PagerAdapter() {
            //多少个切换页面
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            //提供标题的内容
            @Override
            public CharSequence getPageTitle(int position) {
                // TODO Auto-generated method stub
                return titles[position];
            }

            //对超出范围的资源进行销毁
            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
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

    }
}
