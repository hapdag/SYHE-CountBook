package com.example.countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_counter);
    }

    public void addCounterAction (View view){
        Toast.makeText(this,"add counter action.",Toast.LENGTH_SHORT).show();
        CounterListController ct = new CounterListController();
        EditText counterName = (EditText) findViewById(R.id.addCounterNameText);
        EditText counterValue = (EditText) findViewById(R.id.initCounterValueNumber);
        EditText counterComment = (EditText) findViewById(R.id.counterCommentText);
        ct.addCounter(new Counter(counterName.getText().toString(),Integer.parseInt(counterValue.getText().toString()),counterComment.getText().toString()));
    }

}
