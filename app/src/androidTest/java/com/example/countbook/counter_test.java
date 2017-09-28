package com.example.countbook;

import junit.framework.TestCase;
import com.example.countbook.Counter;
/**
 * Created by Saddog on 9/27/2017.
 */

public class counter_test extends TestCase {
    public void testCounter(){

        String counterName = "New counter";
        Integer initValue = 12;
        String counterComment = "New counter comment";
        Counter counter = new Counter(counterName,initValue,counterComment);
        assertTrue("The counter name is not equals", counterName.equals(counter.getName()));
        counter.setComment("edited comment here");
        counter.setName("edited counter name");
        assertFalse("The counter name is equals", counterName.equals(counter.getComment()));


    }
}
