package com.zgs.android.localbroadcastmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zgs.android.R;

public class SendActivity extends AppCompatActivity {

    public static String LOCAL_ACTION = "LOCAL_ACTION";
    public static String LOCAL_EXTRA = "LOCAL_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }


    public void onTextClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_local_broadcast_manager:
                configLocalBroadcastAndSend();
                break;
        }
    }

    /**
     * 配置要发送的广播和数据
     */
    private void configLocalBroadcastAndSend() {
        Intent intent = new Intent();
        //设置自定义的action用于识别
        intent.setAction(LOCAL_ACTION);
        //发送要送递的数据
        intent.putExtra(LOCAL_EXTRA, getString(R.string.local_broad_cast_success));
        //发送广播
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

}
