package com.example.luis.appprueba;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class MainMenuActivity extends AppCompatActivity {
    private ListView m_listview;
    String tag = "MAINMENU";
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String type = "mainmenu";
        BackgroundWorkerMainMenu backgroundWorker = new BackgroundWorkerMainMenu(this);
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
        String[] split = res.split("--");
        Log.d(tag, split[0]);
        Log.d(tag, split[1]);

        ArrayList<String> items = new ArrayList<>();

        for(String i:split){
            String[] split1 = i.split(",");
            String s = "· Autor: "+split1[0]+" , CF: "+split1[1]+" , Date: "+split1[2]+" , Country: "+split1[3]+" , City: "+split1[4]+" , Num. of participants: "+split1[5];
            items.add(s);
        }
        //Log.d(tag, String.valueOf(split.length));

        /*String[] split = res.split(",");

        Intent myIntent = new Intent(getApplicationContext(),this.getClass());
        myIntent.getExtras();
        id.setText(username);
        email.setText(split[1]);
        phone.setText(split[2]);
        country.setText(split[3]);
        editeEmail = split[1];
        editePhone = split[2];
        editeCountry = split[3];
        */
        m_listview = (ListView) findViewById(R.id.id_list_view);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);


        m_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String evento = ((TextView) view).getText().toString();

            }
        });
        m_listview.setAdapter(adapter);

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
                Intent user = getIntent();
                String username2 = user.getStringExtra("iduser");
                myIntent = new Intent(getApplicationContext(), NewEventActivity.class);
                myIntent.putExtra("iduser",username2);
                startActivity(myIntent);
                break;
            case R.id.search:
                /*Intent myIntent3;
                myIntent3 = new Intent(getApplicationContext(), SearchEvent.class);
                startActivity(myIntent3);
                break;*/
                Intent myIntent3;
                Intent me2 = getIntent();
                String username3 = me2.getStringExtra("iduser");
                myIntent3 = new Intent(getApplicationContext(), EventActivity.class);
                myIntent3.putExtra("iduser",username3);
                startActivity(myIntent3);
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
