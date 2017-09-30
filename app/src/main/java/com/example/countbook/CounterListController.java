package com.example.countbook;

/**
 * Created by Saddog on 9/29/2017.
 */

public class CounterListController {
    private static CounterList counterList = null;
    static public CounterList getCounterList() {
        if (counterList == null) {
            counterList = new CounterList();
        }
        return counterList;}

        public void addCounter(Counter counter) {
        getCounterList().addCounter(counter);
        }
}
