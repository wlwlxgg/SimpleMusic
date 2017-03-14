package com.example.wlwlxgg.simplemusic.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.adapter.MyListViewAdapter;
import com.example.wlwlxgg.simplemusic.db.dao.UserDao;
import com.example.wlwlxgg.simplemusic.domain.MusicInfo;
import com.example.wlwlxgg.simplemusic.domain.SearchResult;
import com.example.wlwlxgg.simplemusic.net.HttpManager;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wlwlxgg on 2017/2/22.
 */

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private EditText edit;
    private Button cancel;
    private PullToRefreshListView list_view;
    private List<SearchResult.ResultBean.SongInfoBean.SongListBean> mList;
    private MyListViewAdapter adapter;
    private int page_num;
    private MusicInfo mMusicInfo;
    private PrefsUtil prefsUtil;
    private UserDao dao;

    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Bundle bundle = msg.getData();
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(SearchActivity.this, PlayActivity.class);
                    startActivity(intent);
                    SearchActivity.this.finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        prefsUtil = PrefsUtil.getInstance();
        dao = new UserDao(this);
        StatusBarUtil.setColor(SearchActivity.this, 0xffffff, 0);
        initView();
    }

    private void initView() {
        edit = (EditText) findViewById(R.id.edit);
        edit.addTextChangedListener(textWatch);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        mList = new ArrayList<>();
        list_view = (PullToRefreshListView) findViewById(R.id.list_view);
        adapter = new MyListViewAdapter(this, mList);
        list_view.setAdapter(adapter);
        list_view.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        list_view.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                new GetDataTask().execute();
            }
        });
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song_id = mList.get(position - 1).getSong_id();
                HttpManager.getMusicRequest(song_id).enqueue(new Callback<MusicInfo>() {
                    @Override
                    public void onResponse(Call<MusicInfo> call, Response<MusicInfo> response) {
                        mMusicInfo = response.body();
                        prefsUtil.putObject("MusicInfo", mMusicInfo);
                        prefsUtil.putInt("isRestart", 0);
                        dao.saveMusicInfo(mMusicInfo);
                        Message message = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("musicInfo", mMusicInfo);
                        message.setData(bundle);
                        message.what = 1;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onFailure(Call<MusicInfo> call, Throwable t) {

                    }
                });
            }
        });
    }


    private TextWatcher textWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s.toString())) {
                page_num = 0;
                getData(page_num);
            }else {
                mList.clear();
                adapter.notifyDataSetChanged();
            }
        }
    };

    private void getData(final int page_num) {
        String Page_num = Integer.toString(page_num);
        HashMap<String, String> map = new HashMap<>();
        map.put("from", "android");
        map.put("version", "5.6.5.0");
        map.put("method", "baidu.ting.search.merge");
        map.put("format", "json");
        map.put("query", edit.getText().toString());
        map.put("page_no", Page_num);
        map.put("page_size", "20");
        map.put("type", "-1");
        map.put("data_source", "0");
        map.put("use_cluster", "1");
        HttpManager.getSearchRequest(map).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (page_num == 0)
                    mList.clear();
                if (response.body().getResult().getSong_info()!= null) {
                    for (int i = 0; i < response.body().getResult().getSong_info().getSong_list().size(); i++) {
                        if (response.body() != null && response.body().getResult().getSong_info() != null)
                            mList.add(response.body().getResult().getSong_info().getSong_list().get(i));
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                t.toString();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                mList.clear();
                adapter.notifyDataSetChanged();
                edit.setText("");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SearchActivity.this, PlayActivity.class);
        startActivity(intent);
        this.finish();
        super.onBackPressed();
    }

    private class GetDataTask extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            getData(page_num++);
            list_view.onRefreshComplete();
        }
    }
}
