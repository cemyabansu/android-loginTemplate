package com.cemyabansu.logintemplate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginTemplate extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_template);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");

        TextView tv_welcome = (TextView) findViewById(R.id.tv_welcome);

        tv_welcome.setText(String.format("Welcome %s", userName));
    }
}
