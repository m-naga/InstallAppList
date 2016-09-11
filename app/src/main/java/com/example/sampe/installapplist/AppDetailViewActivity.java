package com.example.sampe.installapplist;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AppDetailViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail_view);

        TextView appNameView = (TextView) findViewById(R.id.appName);
        TextView appPackageNameView = (TextView) findViewById(R.id.appPackageName);
        ImageView appIconView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        ApplicationInfo app = intent.getParcelableExtra("AppInfo");

        PackageManager pm = this.getPackageManager();

        Drawable appIcon = app.loadIcon(pm);
        String appName = app.loadLabel(pm).toString();
        String appPackageName = app.packageName;

        appNameView.setText(appName);
        appPackageNameView.setText(appPackageName);
        appIconView.setImageDrawable(appIcon);
    }
}
