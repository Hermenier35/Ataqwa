package com.example.ataqwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ataqwa.Requests.Log;

public class EnseignantActivity extends AppCompatActivity {
    private Log myLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enseignant);

        Intent intent = getIntent();

        if(intent != null){
            if(intent.hasExtra("KEY_Log")){
                this.myLog = (Log) intent.getSerializableExtra("KEY_Log");
            }
        }
    }
}