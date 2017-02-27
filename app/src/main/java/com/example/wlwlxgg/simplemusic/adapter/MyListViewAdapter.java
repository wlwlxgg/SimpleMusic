package com.example.wlwlxgg.simplemusic.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.domain.SearchResult;

import java.util.List;

/**
 * Created by wlwlxgg on 2017/2/27.
 */

public class MyListViewAdapter extends BaseAdapter {
    Context context;
    List<SearchResult.ResultBean.SongInfoBean.SongListBean> mList;

    public MyListViewAdapter(Context context, List<SearchResult.ResultBean.SongInfoBean.SongListBean> mList) {
        this.context = context;
        this.mList = mList;
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
        viewHolder.name.setText(mList.get(position).getTitle());
        viewHolder.author.setText(mList.get(position).getAuthor());
        viewHolder.album.setText(mList.get(position).getAlbum_title());
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }
    private class ViewHolder {
        TextView name, author, album;
    }
}
