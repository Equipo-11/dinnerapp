package com.example.luis.appprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class SearchEvent extends AppCompatActivity {
    EditText country,city,date,food;
    String tag = "SEARCH";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        country = (EditText) findViewById(R.id.editCountrySearch);
        city = (EditText) findViewById(R.id.editCitySearch);
        date = (EditText) findViewById(R.id.editDateSearch);
        food = (EditText) findViewById(R.id.editFoodSearch);
        Intent me = getIntent();
        username = me.getStringExtra("iduser");
        Intent myIntent = new Intent(getApplicationContext(),FiltredEvents.class);
        myIntent.putExtra("iduser",username);

    }

    public void searchBack(View view) {
        finish();
    }

    public void searchEvent(View view) {
        String coun = country.getText().toString();
        String ci = city.getText().toString();
        String da = date.getText().toString();
        String cf = food.getText().toString();
        String type = "searchEvent";
        BackgroundWorkerSearch backgroundWorker = new BackgroundWorkerSearch(this);
        backgroundWorker.execute(type, coun, ci, da, cf);
        String res = null;
        try {
            res = backgroundWorker.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(res.equals("No event matches")) {
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
            finish();
        }else {
            String[] row = res.split("--");
            Intent myIntent = new Intent(getApplicationContext(), FiltredEvents.class);
            myIntent.putExtra("eventos", row);
        /*int nr =  (row.length);
        for(int i = 0;i<row.length;i++) {
            String[] split = row[i].split(",");
            Log.d(tag,split[1]);
            myIntent.putExtra("eventos",);
        }*/
            startActivity(myIntent);
        }

    }
}

