package com.example.wlwlxgg.simplemusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.adapter.HistoryListAdapter;
import com.example.wlwlxgg.simplemusic.adapter.MyListViewAdapter;
import com.example.wlwlxgg.simplemusic.db.dao.UserDao;
import com.example.wlwlxgg.simplemusic.domain.NativeInfo;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;

import java.util.ArrayList;

/**
 * Created by wlwlxgg on 2017/3/7.
 */

public class HistoryActivity extends BaseActivity{
    ListView history_list;
    HistoryListAdapter adapter;
    PrefsUtil prefsUtil;
    UserDao dao;
    ArrayList<NativeInfo> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initData();
    }

    private void initView() {
        history_list = (ListView) findViewById(R.id.history_list);
    }

    private void initData() {
        dao = new UserDao(this);
        prefsUtil = PrefsUtil.getInstance();
        getData();
        adapter = new HistoryListAdapter(this, mList);
        history_list.setAdapter(adapter);
    }

    private ArrayList<NativeInfo> getData() {
        mList = dao.getMusicInfo(prefsUtil.getString("userName"));
        return  mList;
    }

}
