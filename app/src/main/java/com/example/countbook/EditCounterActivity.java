package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditCounterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_counter);
        CounterListManager.initManager(this.getApplicationContext());
//
        Intent intent =getIntent();
        Counter editCounter =(Counter)intent.getExtras().get("passCounter");
        String name = editCounter.getName();
        String comment = editCounter.getComment();
        String date = editCounter.getDate();
        TextView commentTextView = (TextView) findViewById(R.id.counterCommentEditText);
        TextView dateTextView = (TextView) findViewById(R.id.counterDateTextView);
        TextView nameTextView = (TextView) findViewById(R.id.counterNameEditText);
        nameTextView.setText(name);
        commentTextView.setText(comment);
        dateTextView.setText(date);
    }




    public void updateTextView() {
    }


}
