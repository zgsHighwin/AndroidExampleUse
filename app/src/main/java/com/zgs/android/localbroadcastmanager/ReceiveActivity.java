package com.zgs.android.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zgs.android.R;

import static com.zgs.android.localbroadcastmanager.SendActivity.LOCAL_EXTRA;

public class ReceiveActivity extends AppCompatActivity {

    private TextView mTvChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        mTvChange = ((TextView) findViewById(R.id.tv_change));

        //注册广播
        LocalBroadcastManager.getInstance(this).registerReceiver(new LocalBroadcastReceiver(), new IntentFilter(SendActivity.LOCAL_ACTION));
    }


    /**
     * 跳转广播发送界面进行测试
     * @param view
     */
    public void onTextClick(View view){
        int id = view.getId();
        switch (id) {
            case R.id.tv_start_to_send:
                startActivity(SendActivity.class);
                break;
        }
    }


    /**
     * 启动Activity
     * @param clazz
     */
    public void startActivity(Class<?> clazz){
        startActivity(new Intent(this,clazz));
    }




    /**
     *  接收广播发送过来的数据，并且刷新数据
     */
    public class LocalBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    //接收广播发送过来的数据
                    String string = extras.getString(LOCAL_EXTRA);
                    Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                    mTvChange.setText(string);
                }
            }
        }
    }
}
