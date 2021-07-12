package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class activityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Toast.makeText(activityLifeCycle.this, "Activity created: onCreate()", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(activityLifeCycle.this, "Activity restarted: onRestart()", Toast.LENGTH_SHORT).show();
    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(activityLifeCycle.this, "Activity started: onStart()", Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(activityLifeCycle.this, "Activity stopped: onStop()", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(activityLifeCycle.this, "Activity resumed: onResume()", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        super.onPause();
        Toast.makeText(activityLifeCycle.this, "Activity paused: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(activityLifeCycle.this, "Activity destroyed: onDestroy()", Toast.LENGTH_SHORT).show();
    }
}