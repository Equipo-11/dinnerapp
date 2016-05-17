package com.example.luis.appprueba;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutionException;

public class ChangePassword extends AppCompatActivity {
    EditText pass1,pass2,pass3;
    String p1,p2,p3;
    String tag = "PASSWORD";
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        pass1 = (EditText)findViewById(R.id.editPass1);
        pass2 = (EditText)findViewById(R.id.editPass2);
        pass3 = (EditText)findViewById(R.id.editPass3);

    }
    public void editPassButton(View view){
        p1 = pass1.getText().toString();
        p2 = pass2.getText().toString();
        p3 = pass3.getText().toString();
        String res= "Passwords don't matche";
        Log.d("PASSWORD",res);
        if(p2.equals(p3)){
            Intent me = getIntent();
            Log.d("PASSWORDif",res);
            String username = me.getStringExtra("username");
            String type = "password";
            BackgroundWorkerPassword backgroundWorker = new BackgroundWorkerPassword(this);
            backgroundWorker.execute(type,username,p1,p2);
            try {
                res = backgroundWorker.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            Log.d(tag,res);
            Toast.makeText(this,res, Toast.LENGTH_SHORT).show();
           /* alertDialog.setMessage(res);
            alertDialog.show();*/
            finish();
        }else{
            Log.d("PASSWORDelse",res);
            Toast.makeText(this,res, Toast.LENGTH_SHORT).show();
            /*alertDialog.setMessage(res);
            alertDialog.show();*/
        }
    }
    public void CancelPassButton(View view){
        finish();
    }
}
