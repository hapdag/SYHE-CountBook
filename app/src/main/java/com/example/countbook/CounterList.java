package com.example.countbook;

import java.util.ArrayList;
/**
 * Created by Saddog on 9/27/2017.
 */

public class CounterList {
    private ArrayList<Counter> counterList;
    protected transient ArrayList<Listener> listeners = null;


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

    private ArrayList<Listener> getListeners() {
        if (listeners == null ) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }


    private void notifyListeners() {
        for (Listener  listener : getListeners()) {
            listener.update();
        }
    }

    public void addCounter(Counter counter) {
        counterList.add(counter);
    }

    public void removeCounter(Counter counter) {
        counterList.remove(counter);
        notifyListeners();
    }

    public void clear() {
        counterList.clear();
    }

    public void addListener(Listener l) {
        getListeners().add(l);
    }

    public void removeListener(Listener l) {
        getListeners().remove(l);
    }

}
