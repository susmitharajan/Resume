package com.example.susmitharajan.resume;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {"Personal Information","Education","Work Experience","Project",
            "Additional Information"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    Intent i = new Intent(getApplicationContext(),personal.class);
                    startActivity(i);
                }
                else if(position == 1){
                    Intent i = new Intent(getApplicationContext(),education.class);
                    startActivity(i);
                }
                else if(position == 2){
                    Intent i = new Intent(getApplicationContext(),work.class);
                    startActivity(i);
                }
                else if(position == 3){
                    Intent i = new Intent(getApplicationContext(),project.class);
                    startActivity(i);
                }
                else if(position == 4){
                    Intent i = new Intent(getApplicationContext(),additional.class);
                    startActivity(i);
                }
            }
        });
    }
}
