package com.example.ataqwa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ataqwa.Requests.Log;
import com.example.ataqwa.Task.LogTask;

public class MainActivity extends AppCompatActivity {

    private Button loginButton,b2, sendButton;
    private EditText enterName,enterPassword;
    private Log myLog;
    int counter = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        sendButton = findViewById(R.id.sendbymail);
        enterName = findViewById(R.id.enterName);
        enterPassword = findViewById(R.id.enterPassword);

        b2 = findViewById(R.id.button2);
        sendButton.setEnabled(false);


        loginButton.setOnClickListener(v -> {
            myLog = new Log(enterName.getText().toString(),enterPassword.getText().toString());
            LogTask myTask = new LogTask("loginaccess", myLog, getApplicationContext(), MainActivity.this);
            myTask.execute();
            counter --;
            if (counter < 1)
                sendButton.setEnabled(true);
        });

        sendButton.setOnClickListener(v -> {
            myLog.setMail(enterName.getText().toString());
            LogTask myTask = new LogTask("sendpassmail", myLog, getApplicationContext());
            myTask.execute();
        });

    }
}