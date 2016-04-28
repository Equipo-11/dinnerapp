package com.example.luis.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutionException;

public class UserProfile extends AppCompatActivity {
    String tag = "PERFIL";
    TextView id,email,phone,country;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        id = (TextView) findViewById(R.id.textID);
        email = (TextView) findViewById(R.id.textEmail);
        phone = (TextView) findViewById(R.id.textPhone);
        country = (TextView) findViewById(R.id.textCountry);



    }
    public void backButton(View view){
        finish();
    }

    public void mostrarProfile(View view){
        String type = "userProfile";
        BackgroundWorkerProfile backgroundWorker = new BackgroundWorkerProfile(this);
        Intent me = getIntent();
        username = me.getStringExtra("iduser");
        backgroundWorker.execute(type, username);
        String res= null;
        try {
            res = backgroundWorker.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d(tag, res);
        String[] split = res.split(",");
        Log.d(tag,split.toString());
        Log.d(tag, split[3]);
        Intent myIntent = new Intent(getApplicationContext(),this.getClass());
        myIntent.getExtras();
        id.setText(username);
        email.setText(split[1]);
        phone.setText(split[2]);
        country.setText(split[3]);
    }

}
