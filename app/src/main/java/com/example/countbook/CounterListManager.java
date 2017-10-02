/*
** Implemented following Doctor Hindle's StudentPicker Saga on youtube
* handles the major IO portion of the app, take a CounterList object and converts into byte string and vise versa
* then the getting and setting of the converted objects is handled by the save/load from file
* CounterManager class is used with CounterListController class along with listeners
* youtube playlist link: https://www.youtube.com/watch?v=5PPD0ncJU1g&list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O
 */

package com.example.countbook;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Saddog on 9/30/2017.
 */


public class CounterListManager {
    static final String prefFile = "CounterList";
    static final String slKey = "counterList";

    Context context;

    static private CounterListManager counterListManager = null;

    public static void initManager(Context context) {
        if (counterListManager == null) {
            if (context==null) {
                throw new RuntimeException("missing context for CounterListManager");
            }
            counterListManager = new CounterListManager(context);
        }
    }

    public static CounterListManager getManager() {
        if (counterListManager==null) {
            throw new RuntimeException("Did not initialize Manager");
        }
        return counterListManager;
    }


    public CounterListManager(Context context) {
        this.context = context;
    }

    public CounterList loadCounterList() throws ClassNotFoundException, IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String counterListData = settings.getString(slKey, "");
        if (counterListData.equals("")) {
            return new CounterList();
        } else {
            return counterListFromString(counterListData);
        }
    }
    static public CounterList counterListFromString(String counterListData) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(counterListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (CounterList)oi.readObject();
    }
    static public String counterListToString(CounterList sl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(sl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes,Base64.DEFAULT);
    }

    public void saveCounterList(CounterList sl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(slKey, counterListToString(sl));
        editor.commit();
    }

}