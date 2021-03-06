package com.example.luis.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CreatedEventsActivity extends AppCompatActivity {
    private ListView m_listview;
    String tag = "CREATED";
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String type = "mainmenu";
        BackgroundWorkerCreatedEvents backgroundWorker = new BackgroundWorkerCreatedEvents(this);
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
        if(res.equals("You didn't create any event!")){
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
            finish();
        }else{
            String[] split = res.split("--");
            //Log.d(tag, split[0]);
            //Log.d(tag, split[1]);

            ArrayList<String> items = new ArrayList<>();

            for(String i:split){
                String[] split1 = i.split(",");
                String s = " Autor: "+split1[0]+"  ,  CountryFood: "+split1[1]+" \n, Date: "+split1[2]+"  ,  Country: "+split1[3]+" \n, City: "+split1[4]+"  ,  Num. of participants: "+split1[5]+" \n, Event Code: "+split1[6];
                items.add(s);
            }
            //Log.d(tag, String.valueOf(split.length));

            m_listview = (ListView) findViewById(R.id.id_list_view);


            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);


            m_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String evento = ((TextView) view).getText().toString();
                    Log.d(tag, evento);
                    String[] split1 = evento.split(",");
                    String[] idev = split1[6].split("Event Code: ");
                    Log.d(tag, idev[1]);
                    Intent myIntent4;
                    myIntent4 = new Intent(getApplicationContext(), EventActivity.class);
                    myIntent4.putExtra("idev", idev[1]);
                    myIntent4.putExtra("iduser", username);
                    startActivity(myIntent4);

                }
            });
            m_listview.setAdapter(adapter);
        }


    }



}
