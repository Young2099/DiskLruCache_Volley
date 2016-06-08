package com.demo.panguso.demo20160516.fragment;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.demo.panguso.demo20160516.R;
import com.demo.panguso.demo20160516.adapter.RecommandAdapter;
import com.demo.panguso.demo20160516.adapter.ViewPagerAdapter;
import com.demo.panguso.demo20160516.base.BaseFragment;

/**
 *
 * Created by yangfang on 2016/5/16.
 */
public class RecommandFragment extends BaseFragment {
    SwipeRefreshLayout view;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager manager;
    RecommandAdapter mAdapter;
    View mHeader;
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;
    LinearLayout point;

    @Override
    public View initView() {
        view = (SwipeRefreshLayout) View.inflate(mContext, R.layout.recommand_fragment, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        manager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
//        mRecyclerView.addItemDecoration(new D);
        mAdapter = new RecommandAdapter(mContext);
        setHead(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private void setHead(RecyclerView view) {
        mHeader = LayoutInflater.from(mContext).inflate(R.layout.common_viewpager, view, false);
        mAdapter.setHeadrView(mHeader);
        mViewPager = (ViewPager) mHeader.findViewById(R.id.r_viewpager);
        point = (LinearLayout) mHeader.findViewById(R.id.ll_group_point);
        mViewPagerAdapter = new ViewPagerAdapter(mContext, mViewPager, point);
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
