package com.example.luis.appprueba;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;

public class UserProfile extends AppCompatActivity {
    String tag = "PERFIL";
    TextView id,email,phone,country;
    EditText editEm,editPh,editCo;
    String username, editeEmail,editePhone,editeCountry;
    Button boton1,boton2,boton3;
    Boolean e1=false;
    Boolean e2=false;
    Boolean e3=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        id = (TextView) findViewById(R.id.textID);
        email = (TextView) findViewById(R.id.textEmail);
        phone = (TextView) findViewById(R.id.textPhone);
        country = (TextView) findViewById(R.id.textCountry);
        editEm = (EditText) findViewById(R.id.editeP1);
        editPh = (EditText) findViewById(R.id.editeP2);
        editCo = (EditText) findViewById(R.id.editeP3);
        boton1 = (Button) findViewById(R.id.editP1);
        boton2 = (Button) findViewById(R.id.editP2);
        boton3 = (Button) findViewById(R.id.editP3);
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
        editeEmail = split[1];
        editePhone = split[2];
        editeCountry = split[3];

    }
    public void backButton(View view){
        finish();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void editP1 (View view){
        findViewById(R.id.textEmail).setVisibility(View.INVISIBLE);
        findViewById(R.id.editeP1).setVisibility(View.VISIBLE);
        findViewById(R.id.editProfileButton).setVisibility(View.VISIBLE);
        editeEmail = editEm.getText().toString();
        if(e1==false){
            e1=true;
            boton1.setBackground(getDrawable(R.drawable.tick));
        }else{
            e1=false;
            boton1.setBackground(getDrawable(R.drawable.edit));
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void editP2 (View view){
        findViewById(R.id.textPhone).setVisibility(View.INVISIBLE);
        findViewById(R.id.editeP2).setVisibility(View.VISIBLE);
        findViewById(R.id.editProfileButton).setVisibility(View.VISIBLE);
        editePhone = editPh.getText().toString();
        if(e2==false){
            e2=true;
            boton2.setBackground(getDrawable(R.drawable.tick));
        }else{
            e2=false;
            boton2.setBackground(getDrawable(R.drawable.edit));
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void editP3 (View view){
        findViewById(R.id.textCountry).setVisibility(View.INVISIBLE);
        findViewById(R.id.editeP3).setVisibility(View.VISIBLE);
        findViewById(R.id.editProfileButton).setVisibility(View.VISIBLE);
        editeCountry = editCo.getText().toString();
        if(e3==false){
            e3=true;
            boton3.setBackground(getDrawable(R.drawable.tick));
        }else{
            e3=false;
            boton3.setBackground(getDrawable(R.drawable.edit));
        }
    }
    public void changePassword(View view){
        Intent myIntent5 = new Intent(getApplicationContext(),ChangePassword.class);
        myIntent5.putExtra("username",username);
        startActivity(myIntent5);
    }

    public void myEvents(View view){
        Intent myIntent4;
        Intent me = getIntent();
        String username = me.getStringExtra("iduser");
        myIntent4 = new Intent(getApplicationContext(), MyEventsActivity.class);
        myIntent4.putExtra("iduser",username);
        startActivity(myIntent4);
    }

    public void createdEvents(View view){
        Intent myIntent2;
        Intent me = getIntent();
        String username = me.getStringExtra("iduser");
        myIntent2 = new Intent(getApplicationContext(), CreatedEventsActivity.class);
        myIntent2.putExtra("iduser",username);
        startActivity(myIntent2);
    }

    public void editProfile(View view){
        String type = "editProfile";
        BackgroundWorkerProfile backgroundWorker = new BackgroundWorkerProfile(this);
        backgroundWorker.execute(type, username, editeEmail, editePhone, editeCountry);
        email.setText(editeEmail);
        phone.setText(editePhone);
        country.setText(editeCountry);
        findViewById(R.id.textEmail).setVisibility(View.VISIBLE);
        findViewById(R.id.editeP1).setVisibility(View.INVISIBLE);
        findViewById(R.id.textPhone).setVisibility(View.VISIBLE);
        findViewById(R.id.editeP2).setVisibility(View.INVISIBLE);
        findViewById(R.id.textCountry).setVisibility(View.VISIBLE);
        findViewById(R.id.editeP3).setVisibility(View.INVISIBLE);
        findViewById(R.id.editProfileButton).setVisibility(View.INVISIBLE);

    }
}
