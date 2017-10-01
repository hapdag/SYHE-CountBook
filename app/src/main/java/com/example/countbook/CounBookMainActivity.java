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

public class CounBookMainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    private ArrayList<Counter> list;
    private static ListView counterListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coun_book_main);

    }

    @Override
    protected void onStart() {

        super.onStart();
        loadFromFile();
        Collection<Counter> counters = CounterListController.getCounterList().getCounters();
        counterListView = (ListView) findViewById(R.id.counterListView);
        //line(1) copied from lonely twitter format, should be left alone for Dr.Hindle's implementation
        CounterList counterList;
        list = new ArrayList<>(counters);
        final ArrayAdapter<Counter> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        counterListView.setAdapter(adapter);
        updateTextView();


        //stack overflow code on making ListView item clickable
        //here is attempt
/*        counterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

            }
        });
*/
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
                        updateTextView();
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.setNegativeButton("View/Edit",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CounBookMainActivity.this, EditCounterActivity.class);
                        startActivity(intent);
                    }
                });
                adb.show();
                return false;
            }
        });
    }


    public void updateTextView() {
        Integer update =list.size();
        TextView textView = (TextView) findViewById(R.id.totalCountersTextView);
        textView.setText("Summary: "+Integer.toString(update)+" total counters.");
    }

    public void addCountersFunction(View view) {
        Intent intent = new Intent(this, AddCounterActivity.class);
        startActivity(intent);
    }

// code taken from lonely twitter with minor editing

    private void loadFromFile() {
        try {
            FileInputStream fileInputStream = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fileInputStream));
            Gson gson = new Gson();

            //Taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            //2017-9-19

            Type listType = new TypeToken<ArrayList<Counter>>() {
            }.getType();
            list = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            list = new ArrayList<Counter>();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			throw new RuntimeException();
//		}
        }
    }
}
/*
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);

            BufferedWriter out =new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(counterList,out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}
*/