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

    public ArrayList<Counter> getCounters (){
        return counterList;
    }

    public Counter getCounter(String counterName){
        for(Counter counter: counterList ){
            if(counter.getName().equals(counterName)) {return counter;}}
        return null;
    }

    public void addCounter(Counter counter) {
        counterList.add(counter);
    }

    public void removeCounter(Counter counter) {
        counterList.remove(counter);
    }

    public void clear() {
        counterList.clear();
    }

}
