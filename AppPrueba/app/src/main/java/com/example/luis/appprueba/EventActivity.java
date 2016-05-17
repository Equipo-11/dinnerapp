package com.example.luis.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EventActivity extends AppCompatActivity {
    String tag = "EVENTOPRUEBA";
    String source;
    EditText id;
    String id_event_st;
    TextView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    Button b1;
    List<String> arrayParticipantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        b1 = (Button) findViewById(R.id.buttonJoinEvent);
        c1 = (TextView) findViewById(R.id.campoAutorEvento);
        c2 = (TextView) findViewById(R.id.campoCountryFoodEvento);
        c3 = (TextView) findViewById(R.id.campoDateEvento);
        c4 = (TextView) findViewById(R.id.campoCountryEvento);
        c5 = (TextView) findViewById(R.id.campoCityEvento);
        c6 = (TextView) findViewById(R.id.campoAddressEvento);
        c7 = (TextView) findViewById(R.id.campoNumberParticipantEvento);
        c8 = (TextView) findViewById(R.id.campoDescriptionEvento);
        c9 = (TextView) findViewById(R.id.campoParticipantsEvento);
        //AQUI TIENES QUE TOCAR xD
        Intent me = getIntent();
        id_event_st = me.getStringExtra("idev");
        mostrarPrueba(id_event_st);


    }
    public void backButton(View view){
        finish();
    }

    public void mostrarPrueba(String id_evento_vista){
        String type = "eventPrueba";
        BackgroundWorkerEventPrueba backgroundWorker = new BackgroundWorkerEventPrueba(this);
        //String id_evento=id.getText().toString();
        String id_evento = id_evento_vista;
        backgroundWorker.execute(type, id_evento);
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
        Log.d("eventPruebaSplit",split[0]);
        id_event_st = split[0];
        mostrarParticipantes(id_event_st);
        Intent me4 = getIntent();
        String username = me4.getStringExtra("iduser");
        for(String nombre:arrayParticipantes){
            if(nombre.equals(username)){
                Log.d("array","SI");
                b1.setText("Quit");
                break;
            }else{
                Log.d("array","NO");
                b1.setText("Join to event");
            }
        }
    }

    public void unirseAlEvento(View view){
        String type = "unirseAlEvento";
        Intent me4 = getIntent();
        String username = me4.getStringExtra("iduser");
        BackgroundWorkerEventPrueba backgroundWorker2 = new BackgroundWorkerEventPrueba(this);
        //String national1=id.getText().toString();
        Log.d(type, id_event_st+" "+username);
        backgroundWorker2.execute(type, id_event_st, username);
        String res= null;
        try {
            res = backgroundWorker2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        mostrarParticipantes(id_event_st);
    }

    public void eliminarEvento(View view){

        String type = "eliminarEvento";
        BackgroundWorkerEventPrueba backgroundWorker4 = new BackgroundWorkerEventPrueba(this);
        //String national1=id.getText().toString();
        Intent me4 = getIntent();
        String username = me4.getStringExtra("iduser");
        String id_evento_eliminar = me4.getStringExtra("iduser");
        backgroundWorker4.execute(type, id_event_st,username);
        String res= null;
        try {
            res = backgroundWorker4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("DELETE",res);
        if(res.equals("Event deleted")){
            Toast.makeText(this,res, Toast.LENGTH_SHORT).show();
            finish();
        }
        if(res.equals("You can't delete this event!")){
            Toast.makeText(this,res, Toast.LENGTH_SHORT).show();
        }

    }

    public void mostrarParticipantes(String id_event){
        String type = "mostrarParticipantes";
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
        arrayParticipantes = new ArrayList<String>();
        Log.d("mostrarParticipantes",split[split.length-1]);
        for(int i=0;i<split.length-1;i++){
            result+= split[i]+", ";
            arrayParticipantes.add(split[i]);
        }
        arrayParticipantes.add(split[split.length-1]);
        result += split[split.length-1]+ " .";
        Log.d("mostrarParticipantes",result);
        c9.setText(result);
        Intent me4 = getIntent();
        String username = me4.getStringExtra("iduser");
        for(String nombre:arrayParticipantes){
            if(nombre.equals(username)){
                Log.d("array","SI");
                b1.setText("Quit");
                break;
            }else{
                Log.d("array","NO");
                b1.setText("Join to event");
            }
        }
    }

}
