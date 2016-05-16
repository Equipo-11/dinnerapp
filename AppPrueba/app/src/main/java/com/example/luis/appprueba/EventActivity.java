package com.example.luis.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class EventActivity extends AppCompatActivity {
    String tag = "EVENTOPRUEBA";
    EditText id;
    String id_event_st;
    TextView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        id = (EditText) findViewById(R.id.editTextPruebaEvento);
        c1 = (TextView) findViewById(R.id.campoAutorEvento);
        c2 = (TextView) findViewById(R.id.campoCountryFoodEvento);
        c3 = (TextView) findViewById(R.id.campoDateEvento);
        c4 = (TextView) findViewById(R.id.campoCountryEvento);
        c5 = (TextView) findViewById(R.id.campoCityEvento);
        c6 = (TextView) findViewById(R.id.campoAddressEvento);
        c7 = (TextView) findViewById(R.id.campoNumberParticipantEvento);
        c8 = (TextView) findViewById(R.id.campoDescriptionEvento);
        c9 = (TextView) findViewById(R.id.campoParticipantsEvento);

    }
    public void backButton(View view){
        finish();
    }

    public void mostrarPrueba(View view){
        String type = "eventPrueba";
        BackgroundWorkerEventPrueba backgroundWorker = new BackgroundWorkerEventPrueba(this);
        String national1=id.getText().toString();
        backgroundWorker.execute(type, national1);
        String res= null;
        try {
            res = backgroundWorker.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String[] split = res.split(",");
        c1.setText(split[1]);
        c2.setText(split[2]);
        c3.setText(split[3]);
        c4.setText(split[4]);
        c5.setText(split[5]);
        c6.setText(split[6]);
        c7.setText(split[7]);
        c8.setText(split[8]);
        Log.d("SPLIT0",split[0]);
        id_event_st = split[0];
        mostrarParticipantes(view, id_event_st);
    }

    public void unirseAlEvento(View view){
        String type = "unirse";
        BackgroundWorkerEventPrueba backgroundWorker2 = new BackgroundWorkerEventPrueba(this);
        String national1=id.getText().toString();
        backgroundWorker2.execute(type, national1);
        String res= null;
        try {
            res = backgroundWorker2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //String[] split = res.split()
        String[] split = res.split(",");
        String result = "";
        Log.d("unirse",split[split.length-1]);
        for(int i=0;i<split.length-1;i++){
            result+= split[i]+", ";
        }
        result += split[split.length-1]+ ".";
        Log.d("unirse",result);
        c9.setText(result);
    }

    public void mostrarParticipantes(View view,String id_event){
        String type = "unirse";
        BackgroundWorkerEventPrueba backgroundWorker3 = new BackgroundWorkerEventPrueba(this);
        //String national1=id.getText().toString();
        backgroundWorker3.execute(type, id_event);
        String res= null;
        try {
            res = backgroundWorker3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //String[] split = res.split()
        String[] split = res.split(",");
        String result = "";
        Log.d("unirse",split[split.length-1]);
        for(int i=0;i<split.length-1;i++){
            result+= split[i]+", ";
        }
        result += split[split.length-1]+ ".";
        Log.d("unirse",result);
        c9.setText(result);
    }

}
