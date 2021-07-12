package com.example.colourchanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_layout);
    }

    public void blueOnClick(View view) {
        layout.setBackgroundColor(Color.BLUE);
    }

    public void redOnClick(View view) {
        layout.setBackgroundColor(Color.RED);
    }

    public void yellowOnClick(View view) {
        layout.setBackgroundColor(Color.YELLOW);
    }

}