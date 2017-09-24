package com.example.countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CounBookMainActivity extends AppCompatActivity {
    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coun_book_main);
    }

    @Override
    protected void onStart(){

    }
}
