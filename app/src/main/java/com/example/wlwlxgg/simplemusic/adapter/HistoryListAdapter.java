package com.example.wlwlxgg.simplemusic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.domain.NativeInfo;

import java.util.ArrayList;

/**
 * Created by wlwlxgg on 2017/3/7.
 */

public class HistoryListAdapter extends BaseAdapter {

    private ArrayList<NativeInfo> mList;
    private Context context;

    public HistoryListAdapter(Context context, ArrayList<NativeInfo> list) {
        this.mList = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.activity_searchitem, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.author = (TextView) convertView.findViewById(R.id.author);
            viewHolder.album = (TextView) convertView.findViewById(R.id.album);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.name.setText(mList.get(position).getSongName());
        viewHolder.author.setText(mList.get(position).getSingerName());
        viewHolder.album.setText(mList.get(position).getAlbumName());
        return convertView;
    }

    private class ViewHolder {
        TextView name, author, album;
    }


}
