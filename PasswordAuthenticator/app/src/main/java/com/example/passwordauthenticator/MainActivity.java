package com.example.passwordauthenticator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName, ePassword;
    private Button eLogin;
    private TextView attempts;

    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = (EditText) findViewById(R.id.etName);
        ePassword = (EditText) findViewById(R.id.etPassword);
        eLogin = (Button) findViewById(R.id.btnLogin);
        attempts = (TextView) findViewById(R.id.tvAttempts);
    }

    public void loginOnClick(View view) {
        String inputName = eName.getText().toString();
        String inputPassword = ePassword.getText().toString();

        if(inputName.isEmpty() || inputPassword.isEmpty())
            Toast.makeText(MainActivity.this, "Please enter all the details", Toast.LENGTH_LONG).show();

        else {
            boolean isValid = validate(inputName, inputPassword);

            if(!isValid) {
                count--;

                Toast.makeText(MainActivity.this, "Please enter correct credentials", Toast.LENGTH_LONG).show();
                attempts.setText("Number of attempts left: " + count);

                if(count == 0)
                    eLogin.setEnabled(false);
            }
            else {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, homePage.class);
                startActivity(intent);
            }
        }
    }

    private boolean validate(String inputName, String inputPassword) {
        String password = "12345678";
        String username = "Shivam";
        return inputName.equals(username) && inputPassword.equals(password);
    }
}