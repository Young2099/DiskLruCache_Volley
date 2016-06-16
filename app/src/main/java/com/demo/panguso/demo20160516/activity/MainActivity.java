package com.demo.panguso.demo20160516.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.demo.panguso.demo20160516.R;
import com.demo.panguso.demo20160516.adapter.MainAdapter;
import com.demo.panguso.demo20160516.fragment.ArriveFragment;
import com.demo.panguso.demo20160516.fragment.Fragment3;
import com.demo.panguso.demo20160516.fragment.RecommandFragment;
import com.demo.panguso.demo20160516.utils.ImageCacheManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private List<Map<String, Object>> mFragments;
    private ImageCacheManager mImageCacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragments();
        initViewPager();
        mImageCacheManager = new ImageCacheManager(this);
    }

    private void initFragments() {
        RecommandFragment fragment1 = new RecommandFragment();
        ArriveFragment fragment2 = new ArriveFragment();
        Fragment3 fragment3 = new Fragment3();
        setFragment(fragment1, "推荐");
        setFragment(fragment2, "目的地");
        setFragment(fragment3, "社区");

    }

    private void initViewPager() {
//        mViewPager.setOffscreenPageLimit(2);
        MainAdapter pageAdapter = new MainAdapter(getSupportFragmentManager());
        if (mFragments != null && !mFragments.isEmpty()) {
            for (int i = 0; i < mFragments.size(); i++) {
                Map<String, Object> map = mFragments.get(i);
                pageAdapter.addFragment((Fragment) map.get("fragment"), (String) map.get("title"));
            }
            mViewPager.setAdapter(pageAdapter);
            mViewPager.setCurrentItem(0);
            mTableLayout.setupWithViewPager(mViewPager);
        }
    }

    private void setFragment(Fragment fragment, String title) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (fragment != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("fragment", fragment);
            map.put("title", title);
            mFragments.add(map);
        }
    }

    private void initView() {
        mTableLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    public ImageCacheManager getImageCacheManager() {
        return mImageCacheManager;
    }
}
