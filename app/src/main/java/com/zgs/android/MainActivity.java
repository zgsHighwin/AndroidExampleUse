package com.zgs.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zgs.android.localbroadcastmanager.ReceiveActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onTextClick(View view){
        int id = view.getId();
        switch (id) {
            case R.id.tv_local_broadcast_manager:
                startActivity(ReceiveActivity.class);
            break;
        }
    }


    public void startActivity(Class<?> clazz){
        startActivity(new Intent(this,clazz));
    }
}
