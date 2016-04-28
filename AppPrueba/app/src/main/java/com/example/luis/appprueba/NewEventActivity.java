package com.example.luis.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewEventActivity extends AppCompatActivity {

    EditText et_national,et_date,et_country,et_city,et_address,et_participant,et_description;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newevent);
        et_national = (EditText) findViewById(R.id.editTextCountryFood);
        et_date = (EditText) findViewById(R.id.editTextDate);
        et_country = (EditText) findViewById(R.id.editTextCountryEvent);
        et_city = (EditText) findViewById(R.id.editTextCity);
        et_address = (EditText) findViewById(R.id.editTextAddress);
        et_participant = (EditText) findViewById(R.id.editTextNumberParticipants);
        et_description = (EditText) findViewById(R.id.editTextDescription);
        Intent me = getIntent();
        username = me.getStringExtra("iduser");
    }


    public void enviarbutton1(View view) {
        String national = et_national.getText().toString();
        String date = et_date.getText().toString();
        String country = et_country.getText().toString();
        String city = et_city.getText().toString();
        String address = et_address.getText().toString();
        String participant = et_participant.getText().toString();
        String description = et_description.getText().toString();

        String type = "newevent";
        BackgroundWorkerNewEvent backgroundWorker = new BackgroundWorkerNewEvent(this);
        backgroundWorker.execute(type,username, national, date, country, city, address,participant,description);
        finish();
    }

    /*public void enviarbutton(View v) {
        id = pid.getText().toString();
        correo = pcorreo.getText().toString();
        pass = ppass.getText().toString();
        //pass2 = ppass2.getText().toString();
        //telefono = ptelefono.getText().toString();
            /*if (pass != pass2) {
                Toast.makeText(getApplicationContext(), "Los campos de contraseña no coinciden.", Toast.LENGTH_LONG).show();
            } else if(id == "" || correo == "" || telefono == "" || pass == "" || pass2 == "") {
                Toast.makeText(getApplicationContext(), "Hay campos del formulario vacíos.", Toast.LENGTH_LONG).show();
            }else{
                new ConexionDB().execute(url, dbName, id, correo, pass, telefono);
            }*/
        //String method = "register";
        //BackgroundTask backgroundTask = new BackgroundTask(this);
        //backgroundTask.execute(/*method,*/id,correo,pass/*,telefono*/);
        /*Toast.makeText(this, "Signing up...", Toast.LENGTH_SHORT).show();
        new BackgroundTask(this).execute(id, correo, pass);
        finish();
    }*/



    public void cancelbutton1(View view) {
        finish();
    }
}