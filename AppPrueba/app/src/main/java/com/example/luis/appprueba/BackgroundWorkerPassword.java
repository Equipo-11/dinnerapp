package com.example.luis.appprueba;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Ireniita on 17/05/2016.
 */
public class BackgroundWorkerPassword  extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorkerPassword (Context ctx) {
        context = ctx;
    }
    String tag = "PASS";
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //String login_url = "http://192.168.1.3/profile.php";
        String login_url = "http://10.0.2.2/password.php";
        //String login_url = "http://equipo11cm.ddns.net/profile.php";
        if(type.equals("password")) {
            try {
                String username = params[1];
                String pass1 = params[2];
                String pass2 = params[3];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8") + "&"
                        + URLEncoder.encode("pass1", "UTF-8") + "=" + URLEncoder.encode(pass1, "UTF-8") + "&"
                        + URLEncoder.encode("pass2", "UTF-8") + "=" + URLEncoder.encode(pass2, "UTF-8")+ "&"
                        + URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                Log.d(tag, result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void onPreExecute() {
    }

    protected void onPostExecute(String result) {
    }

    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
