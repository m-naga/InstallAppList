package com.example.sampe.installapplist;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class InstallAppList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_app_list);

        PackageManager pm = this.getPackageManager();
        List<ApplicationInfo> appInfoList = pm.getInstalledApplications(0);

        ArrayAdapter<String> appNameList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        for(ApplicationInfo app: appInfoList){
            String name = app.loadLabel(pm).toString();
            appNameList.add(name);
        }

        ListView listView = new ListView(this);
        setContentView(listView);
        listView.setAdapter(appNameList);
    }
}
