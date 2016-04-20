package com.example.ireniita.dinnerapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
    private EditText id;
    private EditText email;
    private EditText password;
    private EditText country;
    private Button insertar;
    private Button mostrar;
    private ImageButton mas;
    private ImageButton menos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        setContentView(R.layout.activity_main);

        id=(EditText)findViewById(R.id.id);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        country=(EditText)findViewById(R.id.country);
        //Insertamos los datos de la persona.
        insertar=(Button)findViewById(R.id.insertar);
        insertar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(!id.getText().toString().trim().equalsIgnoreCase("")||
                        !email.getText().toString().trim().equalsIgnoreCase("")||
                        !password.getText().toString().trim().equalsIgnoreCase("")||
                        !country.getText().toString().trim().equalsIgnoreCase(""))

                    new Insertar(MainActivity.this).execute();

                else
                    Toast.makeText(MainActivity.this, "Hay informacion por rellenar", Toast.LENGTH_LONG).show();
            }

        });
        //Mostramos los datos de la persona por pantalla.
        mostrar=(Button)findViewById(R.id.mostrar);
        //Se mueve por nuestro ArrayList mostrando el objeto posterior.
        mas=(ImageButton)findViewById(R.id.mas);
        //Se mueve por nuestro ArrayList mostrando el objeto anterior
        menos=(ImageButton)findViewById(R.id.menos);
    }

    //Inserta los datos de las Personas en el servidor.
  private boolean insertar() {
       HttpClient httpclient;
       List<NameValuePair> nameValuePairs;
       HttpPost httppost;
       httpclient = new DefaultHttpClient();
       httppost = new HttpPost("http://192.168.1.3/dinnerapp/insert.php"); // Url del Servidor
       //A?adimos nuestros datos
       nameValuePairs = new ArrayList<NameValuePair>(4);
       nameValuePairs.add(new BasicNameValuePair("id", id.getText().toString().trim()));
       nameValuePairs.add(new BasicNameValuePair("email", email.getText().toString().trim()));
       nameValuePairs.add(new BasicNameValuePair("password", password.getText().toString().trim()));
       nameValuePairs.add(new BasicNameValuePair("country", country.getText().toString().trim()));

       try {
           httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
           httpclient.execute(httppost);
           return true;
       } catch (UnsupportedEncodingException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (ClientProtocolException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return false;
   }
       //AsyncTask para insertar Personas
       class Insertar extends AsyncTask<String,String,String>{

			private Activity context;

			Insertar(Activity context){
				this.context=context;
			}
			@Override
			protected String doInBackground(final String... params) {
				// TODO Auto-generated method stub
				if(insertar())
					context.runOnUiThread(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(context, "Persona insertada con éxito", Toast.LENGTH_LONG).show();
							id.setText("");
							email.setText("");
							password.setText("");
							country.setText("");
						}
					});
				else
					context.runOnUiThread(new Runnable(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(context, "Persona no insertada con éxito", Toast.LENGTH_LONG).show();
						}
					});
			      return null;
			}
		}

}
