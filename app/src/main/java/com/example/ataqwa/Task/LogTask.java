package com.example.ataqwa.Task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import android.widget.Toast;

import com.example.ataqwa.AccessActivity;
import com.example.ataqwa.AdminActivity;
import com.example.ataqwa.EnseignantActivity;
import com.example.ataqwa.ParentActivity;
import com.example.ataqwa.Requests.Log;

public class LogTask extends AsyncTask {
    private Log log;
    private Context context;
    private Context activity;
    private String requete;
    private String access;

    public LogTask(String requete, Log log, Context context, Context activity){
        this.requete = requete;
        this.log = log;
        this.context = context;
        this.activity = activity;
    }

    public LogTask(String requete, Log log, String access, Context activity){
        this.requete = requete;
        this.log = log;
        this.access = access;
        this.activity = activity;
    }

    public LogTask(String requete, Log log, Context context){
        this.requete = requete;
        this.log = log;
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(Object[] objects) {
        if(requete.equals("loginaccess"))
            log.logInAccess();
        else if(requete.equals("login"))
            log.logIn(this.access);
        else if(requete.equals("sendpassmail"))
            log.sendPassMail();
      return true;
    }

    @Override
    protected void onPostExecute(Object o) {
        if(requete.equals("loginaccess")) {
            if (!log.getAccess().isEmpty()) {

                Toast.makeText(this.context, "Redirecting...", Toast.LENGTH_SHORT).show();
                Intent activityAccessIntent = new Intent(activity, AccessActivity.class);
                activityAccessIntent.putExtra("KEY_Log", log);
                activity.startActivity(activityAccessIntent);
            } else {
                Toast.makeText(this.context, "Wrong  Credentials", Toast.LENGTH_SHORT).show();
            }
        }else if(requete.equals("login") && access.equals("admins")){
            Intent activityAdminIntent = new Intent(activity, AdminActivity.class);
            activityAdminIntent.putExtra("KEY_Log", log);
            activity.startActivity(activityAdminIntent);
        }else if(requete.equals("login") && access.equals("parent")){
            Intent activityAdminIntent = new Intent(activity, ParentActivity.class);
            activityAdminIntent.putExtra("KEY_Log", log);
            activity.startActivity(activityAdminIntent);
        }else if(requete.equals("login") && access.equals("prof")){
            Intent activityAdminIntent = new Intent(activity, EnseignantActivity.class);
            activityAdminIntent.putExtra("KEY_Log", log);
            activity.startActivity(activityAdminIntent);
        }else if (requete.equals("sendpassmail")){
            Toast.makeText(this.context, log.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
