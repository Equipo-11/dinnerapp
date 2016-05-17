package com.example.luis.appprueba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class NewUserActivity extends AppCompatActivity {

    EditText et_id,et_email,et_pass,et_phone,et_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        et_id = (EditText) findViewById(R.id.editText);
        et_pass = (EditText) findViewById(R.id.editText2);
        et_email = (EditText) findViewById(R.id.editText3);
        et_phone = (EditText) findViewById(R.id.editText4);
        et_country = (EditText) findViewById(R.id.editText6);

    }


    public void enviarbutton(View view) {
        String id = et_id.getText().toString();
        String pass = et_pass.getText().toString();
        String email = et_email.getText().toString();
        String phone = et_phone.getText().toString();
        String country = et_country.getText().toString();
        String type = "newuser";
        BackgroundWorkerNewUser backgroundWorker = new BackgroundWorkerNewUser(this);
        backgroundWorker.execute(type, id, pass, email, phone, country);
        String res = null;
        try {
            res = backgroundWorker.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,res, Toast.LENGTH_SHORT).show();
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



    public void cancelbutton(View view) {
        finish();
    }
}