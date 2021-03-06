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
 * Created by Ireniita on 25/04/2016.
 */
public class BackgroundWorkerProfile extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorkerProfile (Context ctx) {
        context = ctx;
    }
    String tag = "EEE";

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        Log.d(tag,type);
        //String login_url = "http://192.168.1.6/profile.php";
        //String login_url = "http://10.0.2.2/profile.php";
        String login_url = "http://equipo11cm.ddns.net/profile.php";
        if(type.equals("userProfile")) {
            try {
                String id = params[1];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode(type,"UTF-8")+"&"
                        +URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                Log.d(tag,result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (type.equals("editProfile")){
           // String url1 = login_url+"Edite";
            try {
                String id = params[1];
                String email = params[2];
                String phone = params[3];
                String country = params[4];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode(type,"UTF-8")+"&"
                        +URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"
                        +URLEncoder.encode("country","UTF-8")+"="+URLEncoder.encode(country,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                Log.d(tag,result);
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
    @Override
    protected void onPreExecute() {
        /*alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");*/
    }

    @Override
    protected void onPostExecute(String result) {
        //alertDialog.setMessage(result);
        //alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
