package com.example.multipleimagechooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private int pick_multiple_image = 1, position = 0;
    ArrayList<Uri> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        array = new ArrayList<Uri>();
        imageSwitcher = findViewById(R.id.image);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
    }

    public void previousOnClick(View view) {
        if(position > 0) {
            position--;
            imageSwitcher.setImageURI(array.get(position));
        }
        else
            Toast.makeText(MainActivity.this, "This is first image!!!", Toast.LENGTH_LONG).show();
    }

    public void nextOnClick(View view) {
        if(position < array.size() - 1) {
            position++;
            imageSwitcher.setImageURI(array.get(position));
        }
        else
            Toast.makeText(MainActivity.this, "This is last image!!!", Toast.LENGTH_LONG).show();
    }

    public void chooseOnClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), pick_multiple_image);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == pick_multiple_image && resultCode == RESULT_OK && data != null) {
            if(data.getClipData() != null) {
                int count = data.getClipData().getItemCount();
                for(int i = 0; i < count; i++) {
                    Uri imageUri = data.getClipData().getItemAt(i).getUri();
                    array.add(imageUri);
                }
            }
            else {
                Uri imageUri = data.getData();
                array.add(imageUri);
            }
            imageSwitcher.setImageURI(array.get(0));
            position = 0;
        }
        else
            Toast.makeText(MainActivity.this, "You haven't chosen picture", Toast.LENGTH_LONG).show();
    }
}