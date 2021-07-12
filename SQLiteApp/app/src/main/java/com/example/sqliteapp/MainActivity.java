package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDB;
    EditText etRollNo, etFirstName, etLastName, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DataBaseHelper(this);

        etRollNo = findViewById(R.id.etRollNo);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
    }

    public void addOnClick(View view) {
        boolean isInserted = myDB.insertData(etRollNo.getText().toString(), etFirstName.getText().toString(), etLastName.getText().toString(), etEmail.getText().toString());
        if(isInserted)
            makeToast("Successful insertion of data in Database");
        else
            makeToast("Failure in insertion of data in Database");
    }

    public void viewOnClick(View view) {
        Cursor result = myDB.getAllData();

        if(result.getCount() == 0) {
            showMessage("Error", "Nothing Found in Database");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(result.moveToNext()) {
            buffer.append("Roll No.: " + result.getString(0) + "\n");
            buffer.append("First Name: " + result.getString(1) + "\n");
            buffer.append("Last Name: " + result.getString(2) + "\n");
            buffer.append("Email: " + result.getString(3) + "\n\n");
        }
        showMessage("Data", buffer.toString());
    }

    public void updateOnClick(View view) {
        Integer updatedRows = myDB.updateData(etRollNo.getText().toString(), etFirstName.getText().toString(), etLastName.getText().toString(), etEmail.getText().toString());
        if(updatedRows > 0)
            makeToast("Successful update of data in Database");
        else
            makeToast("Failure in update of data in Database");
    }

    public void deleteOnClick(View view) {
        Integer deletedRows = myDB.deleteData(etRollNo.getText().toString());
        if(deletedRows > 0)
            makeToast("Successful deletion of data in Database");
        else
            makeToast("Failure in deletion of data in Database");
    }

    public void makeToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}