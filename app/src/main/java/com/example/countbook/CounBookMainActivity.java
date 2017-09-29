package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CounBookMainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coun_book_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public void editCounters (MenuItem menu){
        Intent intent = new Intent(this, EditCounterActivity.class);
        startActivity(intent);
    }

    public void addCountersFunction (View view){
        Intent intent = new Intent(this,AddCounterActivity.class);
        startActivity(intent);
    }
}
