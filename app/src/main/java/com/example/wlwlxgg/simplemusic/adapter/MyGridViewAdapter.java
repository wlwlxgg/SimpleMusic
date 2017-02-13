package com.example.wlwlxgg.simplemusic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.domain.PlayList;

import java.util.List;


/**
 * Created by wlwlxgg on 2017/2/6.
 */

public class MyGridViewAdapter extends BaseAdapter{
    private Context mContext;
    private List<PlayList> mList;

    public MyGridViewAdapter(Context context, List<PlayList> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder)convertView.getTag();
        } else {
            convertView = View.inflate(mContext, R.layout.layout_playlist, null);
            holder = new ViewHolder();
            holder.iv_cover = (ImageView)convertView.findViewById(R.id.cover);
            holder.iv_play = (ImageView)convertView.findViewById(R.id.cover_play);
            holder.tv_name = (TextView)convertView.findViewById(R.id.cover_name);
            holder.tv_num = (TextView)convertView.findViewById(R.id.cover_num);
            convertView.setTag(holder);
        }
        holder.tv_name.setText(mList.get(position).getCover_name());
        holder.tv_num.setText(mList.get(position).getCover_num() + "");
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        private ImageView iv_cover, iv_play;
        private TextView tv_name;
        private TextView tv_num;
    }
}
