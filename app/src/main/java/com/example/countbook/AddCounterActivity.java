/*
    Activity responsible for grabbing data from EditView fields on layout
    Error handling for counterValue is NOT IMPLEMENTED, testing with edge cases will case counterValue to crash the app
    e.g. clicking add counter button without editing the string on counterValue EditView field will cause the app to crash
 */

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
        CounterListManager.initManager(this.getApplicationContext());
    }

    public void addCounterAction (View view){
        Toast.makeText(this,"New counter added.",Toast.LENGTH_SHORT).show();
        CounterListController ct = new CounterListController();
        EditText counterName = (EditText) findViewById(R.id.addCounterNameText);
        String counterNameStr = counterName.getText().toString();
        EditText counterValue = (EditText) findViewById(R.id.initCounterValueNumber);
        Integer counterValueInt = Integer.parseInt(counterValue.getText().toString());
        EditText counterComment = (EditText) findViewById(R.id.counterCommentText);
        String counterCommentStr = counterComment.getText().toString();
        ct.addCounter(new Counter(counterNameStr,counterValueInt,counterCommentStr));

        }

}
