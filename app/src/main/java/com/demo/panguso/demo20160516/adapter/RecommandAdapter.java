package com.demo.panguso.demo20160516.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.demo20160516.R;
import com.demo.panguso.demo20160516.holder.DiscountHolder;
import com.demo.panguso.demo20160516.holder.DiscoverHolder;
import com.demo.panguso.demo20160516.holder.MyViewHolder;

import java.util.ArrayList;

/**
 * Created by panguso on 2016/5/17.
 */
public class RecommandAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL1 = 1;
    private static final int TYPE_NORMAL2 = 2;
    private View mHeaderView;
    private ArrayList<String> mDatas = new ArrayList<>();
    Context mContext;

    public RecommandAdapter(Context context) {
        mContext = context;
    }


    public void setHeadrView(View view) {
        mHeaderView = view;
        notifyItemChanged(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position == 0) {
            type = TYPE_HEADER;
        } else if (position == 1) {
            type = TYPE_NORMAL1;
        } else if (position == 2) {
            type = TYPE_NORMAL2;
        }

        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType ==TYPE_HEADER){
            viewHolder  = new MyViewHolder(mHeaderView);
        }
        if (viewType == TYPE_NORMAL2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
            viewHolder = new DiscountHolder(view);

        }
        if (viewType == TYPE_NORMAL1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_second_xml, parent, false);
            viewHolder = new DiscoverHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            return;
        }
        if (holder instanceof DiscountHolder) {
            DiscountHolder viewHolder = (DiscountHolder) holder;
            viewHolder.tv.setText("6666666");
        }
        if (holder instanceof DiscoverHolder) {
            DiscoverHolder viewHolder = (DiscoverHolder) holder;
            viewHolder.iv.setImageResource(R.drawable.a);
//            viewHolder.iv1.setImageResource(R.drawable.b);
//            viewHolder.iv2.setImageResource(R.drawable.d);

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
