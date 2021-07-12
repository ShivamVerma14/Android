package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class fragmentLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_cycle);
    }
}