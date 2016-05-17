package com.example.luis.appprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FiltredEvents extends AppCompatActivity {
    String tag = "FILTRO";
    private ListView m_listview;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtred_events);
        Intent me = getIntent();
        String[] row = me.getStringArrayExtra("eventos");
        ArrayList<String> items = new ArrayList<>();
        Log.d(tag,row[0]);
        username = me.getStringExtra("iduser");
        for(String i:row){
            String[] split1 = i.split(",");
            String s = " Autor: "+split1[0]+"  ,  CountryFood: "+split1[1]+" \n, Date: "+split1[2]+"  ,  Country: "+split1[3]+" \n, City: "+split1[4]+"  ,  Num. of participants: "+split1[5]+" \n, Event Code: "+split1[6];
            items.add(s);
            Log.d(tag,s);
        }
        m_listview = (ListView) findViewById(R.id.id_list_view_filter);


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
                myIntent4.putExtra("idev",idev[1]);
                myIntent4.putExtra("iduser",username);
                startActivity(myIntent4);

            }
        });
        m_listview.setAdapter(adapter);
    }
}
