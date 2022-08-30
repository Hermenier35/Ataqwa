package com.example.ataqwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.ataqwa.Requests.Log;
import com.example.ataqwa.Task.LogTask;

public class AccessActivity extends AppCompatActivity {
    private Button adminButton, parentButton, enseignantButton;
    private Log myLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        Intent intent = getIntent();

        if(intent != null){
            if(intent.hasExtra("KEY_Log")){
                this.myLog = (Log) intent.getSerializableExtra("KEY_Log");
            }
        }

        adminButton = findViewById(R.id.adminButton);
        parentButton = findViewById(R.id.parentButton);
        enseignantButton = findViewById(R.id.enseignantButton);

        if(!myLog.getAccess().contains("admins"))
            adminButton.setEnabled(false);
        if(!myLog.getAccess().contains("parent"))
            parentButton.setEnabled(false);
        if(!myLog.getAccess().contains("prof"))
            enseignantButton.setEnabled(false);

        adminButton.setOnClickListener( v-> {
            LogTask myTask = new LogTask("login", myLog,"admins", AccessActivity.this);
            myTask.execute();
        });

        parentButton.setOnClickListener( v-> {
            LogTask myTask = new LogTask("login", myLog,"parent", AccessActivity.this);
            myTask.execute();
        });

        enseignantButton.setOnClickListener( v-> {
            LogTask myTask = new LogTask("login", myLog,"prof", AccessActivity.this);
            myTask.execute();
        });

    }
}