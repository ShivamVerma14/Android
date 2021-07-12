package com.example.teacher_in_charge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);

        final ListView list = findViewById(R.id.listDept);
        ArrayList<String> array = new ArrayList<>();
        array.add("Computer Science");
        array.add("Mathematics");
        array.add("Physics");
        array.add("Commerce");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        image.setImageResource(R.drawable.computer);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.mathematics);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.physics);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.commerce);
                        break;
                }
            }
        });
    }
}