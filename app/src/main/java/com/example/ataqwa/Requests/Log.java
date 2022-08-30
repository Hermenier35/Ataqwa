package com.example.ataqwa.Requests;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class Log implements Serializable {
    private String mail;
    private String mdp;
    private String accessKey;
    private List<String> access;
    private String message;
    private final String pathUrl ="http://148.60.138.71:8080"; //"http://78.198.229.123:8080"

    public Log(String mail, String mdp){
        this.mail = mail;
        this.mdp = mdp;
        this.access = new ArrayList<String>();
    }

    public void sendPassMail(){
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(pathUrl+"/HelloREST/rest/ataqwa/getPassword/"+this.mail);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            this.message = new Genson().deserialize(scanner.nextLine(),String.class);
            try{
                in.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }catch (Exception e){e.printStackTrace();
            this.message = "impossible d'envoyer la requête";
        }
    }

    public void logInAccess(){
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(pathUrl+"/HelloREST/rest/ataqwa/getLoginAccess/"+this.mail+"/"+this.mdp);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            this.access = new Genson().deserialize(scanner.nextLine(),List.class);
            try{
                in.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public Boolean logIn(String acces){
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(pathUrl+"/HelloREST/rest/ataqwa/getLogin/"+this.mail+"/"+this.mdp+"/"+acces);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            this.accessKey = new Genson().deserialize(scanner.nextLine(),String.class);
            if(!accessKey.equals("error"))
                return true;
            try{
                in.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }catch (Exception e){e.printStackTrace();}
        return false;
    }

    public String getMail() {
        return mail;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public List<String> getAccess() {
        return access;
    }

    public String getMessage() {
        return message;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
