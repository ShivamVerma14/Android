package com.example.loginapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private Button logout_button;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        logout_button = findViewById(R.id.btnLogout);
        message = findViewById(R.id.tvMessage);

        message.setText("Welcome " + MainActivity.username);
    }

    public void logoutOnClick(View view) {
        AlertDialog.Builder dialog_box = new AlertDialog.Builder(Dashboard.this);
        dialog_box.setTitle("Are you sure you want to exit?");

        dialog_box.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog_box.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });

        AlertDialog alertDialog = dialog_box.create();
        alertDialog.show();
    }
}