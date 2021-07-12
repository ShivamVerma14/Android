package com.example.floatingnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etFirst, etSecond;
    private TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirst = findViewById(R.id.etFirstNumber);
        etSecond = findViewById(R.id.etSecondNumber);
        tvAnswer = findViewById(R.id.tvAnswer);
    }

    public void addOnClick(View view) {
        float answer = Float.parseFloat(etFirst.getText().toString()) + Float.parseFloat(etSecond.getText().toString());
        tvAnswer.setText("Answer: " + answer);
    }
}