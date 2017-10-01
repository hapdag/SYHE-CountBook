package com.example.countbook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CounBookMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coun_book_main);
        CounterListManager.initManager(this.getApplicationContext());
    }

    @Override
    protected void onStart() {

        super.onStart();
        ListView counterListView = (ListView) findViewById(R.id.counterListView);
        Collection<Counter> counters = CounterListController.getCounterList().getCounters();
        final ArrayList<Counter> list = new ArrayList<Counter>(counters);
        final ArrayAdapter<Counter> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        counterListView.setAdapter(adapter);

        Integer update =list.size();
        TextView textView = (TextView) findViewById(R.id.totalCountersTextView);
        textView.setText("Summary: "+Integer.toString(update)+" total counters.");

        CounterListController.getCounterList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Counter> students = CounterListController.getCounterList().getCounters();
                list.addAll(students);
                adapter.notifyDataSetChanged();
            }
        });
        counterListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           final int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(CounBookMainActivity.this);
                adb.setMessage("Options "+ list.get(position).toString());
                adb.setCancelable(true);
                adb.setPositiveButton("Delete",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Counter toDeleteCounter = list.get(position);
                        CounterListController.getCounterList().removeCounter(toDeleteCounter);
                        Integer update =list.size();
                        TextView textView = (TextView) findViewById(R.id.totalCountersTextView);
                        textView.setText("Summary: "+Integer.toString(update)+" total counters.");
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.setNegativeButton("View/Edit detail",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CounBookMainActivity.this, EditCounterActivity.class);
                        Counter passCounter = list.get(position);
                        intent.putExtra("passCounter",passCounter);
                        startActivity(intent);
                    }
                });
                adb.show();
                return false;
            }
        });
    }


    public void addCountersFunction(View view) {
        Intent intent = new Intent(this, AddCounterActivity.class);
        startActivity(intent);
    }

}
