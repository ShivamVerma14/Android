package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter firstFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(receiver, firstFilter);

        IntentFilter secondFilter = new IntentFilter("com.example.broadcast.MY_BROADCAST");
        registerReceiver(receiver, secondFilter);
    }

    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

    public void sendBroadcastOnClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.broadcast.MY_BROADCAST");
        intent.putExtra("data", "Nothing to see here, move along!");
        sendBroadcast(intent);
    }
}