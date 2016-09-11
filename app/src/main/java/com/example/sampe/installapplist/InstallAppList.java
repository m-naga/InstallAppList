package com.example.sampe.installapplist;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class InstallAppList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install_app_list);

        PackageManager pm = this.getPackageManager();
        final List<ApplicationInfo> appInfoList = pm.getInstalledApplications(0);

        final ArrayAdapter<String> appNameList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        for(ApplicationInfo app: appInfoList){
            String name = app.loadLabel(pm).toString();
            appNameList.add(name);
        }

        ListView listView = new ListView(this);
        setContentView(listView);
        listView.setAdapter(appNameList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo item = appInfoList.get(position);
                Intent intent = new Intent(InstallAppList.this, AppDetailViewActivity.class);
                intent.putExtra("AppInfo", item);
                startActivity(intent);
            }
        });

    }
}
