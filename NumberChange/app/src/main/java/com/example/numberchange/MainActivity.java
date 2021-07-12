package com.example.numberchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
    }

    private void initTextView() {
        text = (TextView) findViewById(R.id.text);
        number = 0;
        text.setText(Integer.toString(number));
    }

    public void incrementOnClick(View view) {
        number++;
        text.setText(Integer.toString(number));
    }

    public void decrementOnClick(View view) {
        number--;
        text.setText(Integer.toString(number));
    }

    public void resetOnClick(View view) {
        initTextView();
    }
}