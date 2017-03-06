package com.example.wlwlxgg.simplemusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wlwlxgg.simplemusic.R;
import com.example.wlwlxgg.simplemusic.util.PrefsUtil;

/**
 * Created by wlwlxgg on 2017/3/6.
 */

public class LoginActivity extends BaseActivity {
    private EditText input_user_name, input_user_password;
    private Button login;
    private PrefsUtil prefsUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefsUtil = PrefsUtil.getInstance();
        initView();
    }

    private void initView() {
        input_user_name = (EditText) findViewById(R.id.input_user_name);
        input_user_password = (EditText) findViewById(R.id.input_user_password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefsUtil.putString("userName",input_user_name.getText().toString());
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}
