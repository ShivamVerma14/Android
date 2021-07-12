package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activityLifeCycleOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, activityLifeCycle.class);
        startActivity(intent);
    }

    public void fragmentLifeCycleOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, fragmentLifeCycle.class);
        startActivity(intent);
    }
}