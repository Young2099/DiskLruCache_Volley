package com.demo.panguso.demo20160516;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

import com.demo.panguso.demo20160516.Fragment.RecommandFragment;
import com.demo.panguso.demo20160516.Fragment.Fragment2;
import com.demo.panguso.demo20160516.Fragment.Fragment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTableLayout;
    private ViewPager mViewPager;
    private List<Map<String, Object>> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragments();
        initViewPager();
    }

    private void initFragments() {
        RecommandFragment fragment1 = new RecommandFragment();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        setFragment(fragment1, "推荐");
        setFragment(fragment2, "目的地");
        setFragment(fragment3, "社区");

    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(2);
        MainAdapter pageAdapter = new MainAdapter(getSupportFragmentManager());
        if (mFragments != null && !mFragments.isEmpty()) {
            for (int i = 0; i < mFragments.size(); i++) {
                Map<String, Object> map = mFragments.get(i);
                pageAdapter.addFragment((Fragment) map.get("fragment"), (String) map.get("title"));
            }
            mViewPager.setAdapter(pageAdapter);
            mViewPager.setCurrentItem(1);
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
}
