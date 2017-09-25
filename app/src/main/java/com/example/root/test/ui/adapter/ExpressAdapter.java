package com.example.root.test.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.test.R;
import com.example.root.test.bean.ExpressInfo;

import java.util.List;

/**
 * Created by root on 17-9-3.
 */

public class ExpressAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExpressInfo.DataBean> datas;
    private LayoutInflater inflater;

    public ExpressAdapter(Context mContext, List<ExpressInfo.DataBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ViewHolder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.item_express, viewGroup, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.itemExpTvTop.setVisibility(i == 0 ? View.GONE : View.VISIBLE);
        holder.itemExpTvBottom.setVisibility(i == datas.size() - 1 ? View.INVISIBLE : View.VISIBLE);
        holder.itemExpTvDate.setText(datas.get(i).getTime().split(" ")[0]);
        holder.itemExpTvTime.setText(datas.get(i).getTime().split(" ")[1].substring(0, 5));
        holder.itemExpTvContent.setText(datas.get(i).getContext());
        return v;
    }

    class ViewHolder {
        private TextView itemExpTvTop;
        private TextView itemExpTvTime;
        private TextView itemExpTvDate;
        private TextView itemExpTvBottom;
        private TextView itemExpTvContent;

        public ViewHolder(View v) {
            itemExpTvTop = (TextView) v.findViewById(R.id.item_exp_tv_top);
            itemExpTvTime = (TextView) v.findViewById(R.id.item_exp_tv_time);
            itemExpTvDate = (TextView) v.findViewById(R.id.item_exp_tv_date);
            itemExpTvBottom = (TextView) v.findViewById(R.id.item_exp_tv_bottom);
            itemExpTvContent = (TextView) v.findViewById(R.id.item_exp_tv_content);
        }
    }
}
