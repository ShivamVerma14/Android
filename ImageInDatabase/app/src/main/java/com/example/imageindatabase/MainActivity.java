package com.example.imageindatabase;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper myHelper;

    private ImageView image;
    private EditText etFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper = new DatabaseHelper(this);

        image = findViewById(R.id.image);
        etFile = findViewById(R.id.etFileName);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }

    public void addOnClick(View view) {
        String fileName = etFile.getText().toString();
        byte[] imageBytes = createImageBytes(fileName);

        boolean isInserted = myHelper.insertImage(fileName, imageBytes);
        if(isInserted)
            makeToast("Successful insertion of Image in Database");
        else
            makeToast("Failure in insertion of Image in Database");
    }

    public void updateOnClick(View view) {
        String fileName = etFile.getText().toString();
        byte[] imageBytes = createImageBytes(fileName);

        Integer isUpdated = myHelper.updateImage(fileName, imageBytes);
        if(isUpdated > 0)
            makeToast("Successful update of Image in Database");
        else
            makeToast("Failure in update of Image in Database");
    }

    public void fetchOnClick(View view) {
        Cursor cursor = myHelper.fetchImage(etFile.getText().toString());

        if(cursor.getCount() < 1) {
            makeToast("Failure in fetching of Image from Database");
            return;
        }

        try {
            cursor.moveToFirst();
            byte[] imageBytes = cursor.getBlob(0);
            cursor.close();
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            image.setImageBitmap(bitmap);

            makeToast("Successful fetching of Image from Database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOnClick(View view) {
        Integer deletedRows = myHelper.deleteImage(etFile.getText().toString());
        image.setImageResource(R.drawable.ic_baseline_no_photography_24);
        if(deletedRows > 0)
            makeToast("Successful deletion of Image in Database");
        else
            makeToast("Failure in deletion of Image in Database");
    }

    private byte[] createImageBytes(String fileName) {
        String stringFilePath = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS) + "/" + fileName + ".jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(stringFilePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void makeToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}