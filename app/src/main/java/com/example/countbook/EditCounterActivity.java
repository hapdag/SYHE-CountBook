package com.example.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditCounterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_counter);
        CounterListManager.initManager(this.getApplicationContext());

        Intent intent = getIntent();
        final Counter editCounter =(Counter)intent.getExtras().get("passCounter");
        final String name = editCounter.getName();
        final String[] newName = new String[1];
        String comment = editCounter.getComment();
        String date = editCounter.getDate();
        final Integer value = editCounter.getCounterValue();
        final TextView valueTextView = (TextView)findViewById(R.id.counterValueTextView);
        TextView commentTextView = (TextView) findViewById(R.id.counterCommentEditText);
        TextView dateTextView = (TextView) findViewById(R.id.counterDateTextView);
        TextView nameTextView = (TextView) findViewById(R.id.counterNameEditText);
        nameTextView.setText(name);
        commentTextView.setText(comment);
        dateTextView.setText(date);
        valueTextView.setText(""+value);

        Button nameButton = (Button)findViewById(R.id.updateNameButton);
        Button commentButton = (Button)findViewById(R.id.updateCommentButton);
        Button plusButton = (Button)findViewById(R.id.incrementButton);
        Button minusButton = (Button) findViewById(R.id.decrementButton);
        Button resetButton = (Button) findViewById((R.id.resetCounterButton));

        nameButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Toast.makeText(EditCounterActivity.this, "Counter name changed.",Toast.LENGTH_SHORT).show();
                        EditText updateNameEditText = (EditText) findViewById(R.id.counterNameEditText);
                        String updateName = updateNameEditText.getText().toString();
                        CounterListController.getCounterList().getCounter(name).setName(updateName);
                        newName[0] = updateName;
                    }
                });

        commentButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Toast.makeText(EditCounterActivity.this, "Counter comment changed.",Toast.LENGTH_SHORT).show();
                        EditText updateCommentEditText = (EditText) findViewById(R.id.counterCommentEditText);
                        String updateComment = updateCommentEditText.getText().toString();
                        if(CounterListController.getCounterList().getCounter(name)==null){CounterListController.getCounterList().getCounter(newName[0]).setComment(updateComment);}else{
                        CounterListController.getCounterList().getCounter(name).setComment(updateComment);
                        }
                    }
                });

        plusButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if(CounterListController.getCounterList().getCounter(name)==null){CounterListController.getCounterList().getCounter(newName[0]).incrementCounter();
                            valueTextView.setText(""+CounterListController.getCounterList().getCounter(newName[0]).getCounterValue());
                        }else{
                            CounterListController.getCounterList().getCounter(name).incrementCounter();
                            valueTextView.setText(""+CounterListController.getCounterList().getCounter(name).getCounterValue());
                        }


                    }
                });

        minusButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if(CounterListController.getCounterList().getCounter(name)==null){
                            if(CounterListController.getCounterList().getCounter(newName[0]).getCounterValue()-1<0){
                                Toast.makeText(EditCounterActivity.this,"Counter Value cannot go below zero!",Toast.LENGTH_SHORT).show();
                            }else {
                                CounterListController.getCounterList().getCounter(newName[0]).decrementCounter();
                                valueTextView.setText("" + CounterListController.getCounterList().getCounter(newName[0]).getCounterValue());
                            }
                        }else{
                            if(CounterListController.getCounterList().getCounter(name).getCounterValue()-1<0){
                                Toast.makeText(EditCounterActivity.this,"Counter Value cannot go below zero!",Toast.LENGTH_SHORT).show();
                            }else {
                                CounterListController.getCounterList().getCounter(name).decrementCounter();
                                valueTextView.setText("" + CounterListController.getCounterList().getCounter(name).getCounterValue());
                            }
                        }


                    }
                });

        resetButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Toast.makeText(EditCounterActivity.this, "Counter value reset.",Toast.LENGTH_SHORT).show();
                        if(CounterListController.getCounterList().getCounter(name)==null){CounterListController.getCounterList().getCounter(newName[0]).resetCounter();
                            valueTextView.setText("" + CounterListController.getCounterList().getCounter(newName[0]).getCounterValue());}else{
                            CounterListController.getCounterList().getCounter(name).resetCounter();
                            valueTextView.setText("" + CounterListController.getCounterList().getCounter(name).getCounterValue());
                        }
                    }
                });

    }


}
