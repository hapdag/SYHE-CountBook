package com.example.countbook;

import junit.framework.TestCase;

/**
 * Created by Saddog on 9/27/2017.
 */

public class counterlist_test extends TestCase {
    public void testAddCounterList(){
        CounterList counterList = new CounterList();
        String counterName = "New counter";
        Integer initValue = 12;
        String counterComment = "New counter comment";
        Counter testCounter = new Counter(counterName,initValue,counterComment);
        counterList.addCounter(testCounter);
        CounterList.removeCounter(testCounter);
    }
}
