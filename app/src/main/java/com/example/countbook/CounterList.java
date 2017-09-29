package com.example.countbook;

import java.util.ArrayList;
/**
 * Created by Saddog on 9/27/2017.
 */

public class CounterList {
    private ArrayList<Counter> counterList;

    public CounterList(){
        counterList = new ArrayList<Counter>();
    }

    public ArrayList getCounterList (){
        return counterList;
    }


    public void addCounter(Counter counter) {
        counterList.add(counter);
    }

    public void removeCounter(Counter counter) {
        counterList.remove(counter);
    }
}
