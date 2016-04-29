/*
package com.example.luis.appprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class SearchEvent extends AppCompatActivity {
    String country,city,date,food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        EditText coun = (EditText) findViewById(R.id.editCountrySearch);
        EditText ci = (EditText) findViewById(R.id.editCitySearch);
        EditText da = (EditText) findViewById(R.id.editDateSearch);
        EditText cf = (EditText) findViewById(R.id.editFoodSearch);
        country=coun.getText().toString();
        city=ci.getText().toString();
        date=da.getText().toString();
        food=cf.getText().toString();
    }

    public void searchBack(View view) {
        finish();
    }

    public void searchEvent(View view) {
        String type = "searchEvent";
        BackgroundWorkerSearch backgroundWorker = new BackgroundWorkerSearch(this);
        backgroundWorker.execute(type,country,city,date,food);
        String res = null;
        try {
            res = backgroundWorker.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d(tag, res);
        String[] split = res.split(",");
        Log.d(tag, split.toString());
        Log.d(tag, split[3]);
        Intent myIntent = new Intent(getApplicationContext(), this.getClass());
        myIntent.getExtras();
        id.setText(username);
        email.setText(split[1]);
        phone.setText(split[2]);
        country.setText(split[3]);

    }
}
*/
