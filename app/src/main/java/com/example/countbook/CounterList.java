package com.example.countbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Saddog on 9/27/2017.
 */

public class CounterList implements Serializable{

    private ArrayList<Counter> counterList = null;
    protected transient ArrayList<Listener> listeners = null;


    public CounterList(){
        counterList = new ArrayList<Counter>();
        listeners = new ArrayList<Listener>();
    }


    private ArrayList<Listener> getListeners() {
        if (listeners == null ) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    public Collection<Counter> getCounters (){
        return counterList;
    }

    public void addCounter(Counter counter) {
        counterList.add(counter);
        notifyListeners();
    }

    private void notifyListeners() {
        for (Listener  listener : getListeners()) {
            listener.update();
        }
    }

    public void removeCounter(Counter counter) {
        counterList.remove(counter);
        notifyListeners();
    }

    public int size(){
        return counterList.size();
    }

    public Counter getCounter(String counterName){
        for(Counter counter: counterList ){
            if(counter.getName().equals(counterName)) {
                notifyListeners();
                return counter;}}
        return null;
    }


public boolean contains(Counter counter){
    return counterList.contains(counter);
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
