package com.example.ataqwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ataqwa.Requests.Log;

public class AdminActivity extends AppCompatActivity {
    private Log myLog;
    private TextView keyAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Intent intent = getIntent();
        keyAccess = findViewById(R.id.keyAccess);

        if(intent != null){
            if(intent.hasExtra("KEY_Log")){
                this.myLog = (Log) intent.getSerializableExtra("KEY_Log");
            }
        }
        keyAccess.setText(myLog.getAccessKey());
    }
}