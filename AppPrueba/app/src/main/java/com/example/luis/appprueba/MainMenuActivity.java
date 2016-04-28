package com.example.luis.appprueba;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){

            case R.id.closesession:
                finish();
                break;
            case R.id.add:
                Intent myIntent;
                myIntent = new Intent(getApplicationContext(), NewEventActivity.class);
                startActivity(myIntent);
                break;
            case R.id.action_settings:
                Intent myIntent2;
                Intent me = getIntent();
                String username = me.getStringExtra("iduser");
                myIntent2 = new Intent(getApplicationContext(), UserProfile.class);
                myIntent2.putExtra("iduser",username);
                startActivity(myIntent2);

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
