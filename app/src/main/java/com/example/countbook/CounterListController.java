package com.example.countbook;

import java.io.IOException;

/**
 * Created by Saddog on 9/29/2017.
 */
public class CounterListController {

    // Lazy Singleton
    private static CounterList counterList = null;
    // Warning: throws a runTimeException
    static public CounterList getCounterList() {
        if (counterList == null) {
            try {
                counterList = CounterListManager.getManager().loadCounterList();
                counterList.addListener(new Listener() {
                    @Override
                    public void update() {
                        saveCounterList();
                    }
                });
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize CounterList from CounterListManager");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException("Could not deserialize CounterList from CounterListManager");
            }
        }
        return counterList;
    }

    static public void saveCounterList() {
        try {
            CounterListManager.getManager().saveCounterList(getCounterList());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("Could not deserialize CounterList from CounterListManager");
        }
    }

    public void addCounter(Counter counter) {
        getCounterList().addCounter(counter);
    }

}
