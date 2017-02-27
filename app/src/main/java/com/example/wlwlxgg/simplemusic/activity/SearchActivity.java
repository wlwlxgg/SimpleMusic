package com.example.wlwlxgg.simplemusic.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.adapter.MyListViewAdapter;
import com.example.wlwlxgg.simplemusic.domain.SearchResult;
import com.example.wlwlxgg.simplemusic.net.SearchRequest;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://tingapi.ting.baidu.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    SearchRequest searchRequset = retrofit.create(SearchRequest.class);
    Call<SearchResult> call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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
                getData(call, page_num);
            }else {
                mList.clear();
                adapter.notifyDataSetChanged();
            }
        }
    };

    private void getData(Call<SearchResult> call, final int page_num) {
        String Page_num = Integer.toString(page_num);
        call = searchRequset.getSearchRequest("android",
                "5.6.5.0", "baidu.ting.search.merge", "json", edit.getText().toString(), Page_num, "20", "-1", "0", "1");
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (page_num == 0)
                    mList.clear();
                for (int i = 0; i < 20; i++) {
                    if (response.body() != null && response.body().getResult().getSong_info() != null)
                        mList.add(response.body().getResult().getSong_info().getSong_list().get(i));
                }
                adapter.notifyDataSetChanged();
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

    private class GetDataTask extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            getData(call, page_num++);
            list_view.onRefreshComplete();
        }
    }
}
