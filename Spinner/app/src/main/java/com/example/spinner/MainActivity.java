package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.imgPlanets);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        image.setImageResource(R.drawable.sun);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.mercury);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.venus);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.earth);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.mars);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.jupiter);
                        break;
                    case 6:
                        image.setImageResource(R.drawable.saturn);
                        break;
                    case 7:
                        image.setImageResource(R.drawable.uranus);
                        break;
                    case 8:
                        image.setImageResource(R.drawable.neptune);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}