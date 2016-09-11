package com.example.sampe.installapplist;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AppDetailViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail_view);

        Intent intent = getIntent();
        ApplicationInfo app = intent.getParcelableExtra("AppInfo");

    }
}
