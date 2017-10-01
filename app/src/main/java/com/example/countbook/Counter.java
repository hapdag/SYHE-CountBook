package com.example.countbook;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Saddog on 9/23/2017.
 */

public class Counter implements Serializable {
    private String counterName;
    private String counterDate;
    private int counterValue, initValue;
    private String counterComment;



    public Counter(String name, Integer initValue, String comment) {
        this.counterName = name;
        this.counterValue = initValue;
        this.initValue = initValue;
        this.counterComment = comment;
        this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public int incrementCounter() {
        this.counterValue++;
        this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return counterValue;
    }

    ;

    public int decrementCounter() {
        if (this.counterValue - 1 < 0) {
            throw new IllegalArgumentException("Counter value cannot go less than 0.");
        } else {
            this.counterValue--;
            this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return counterValue;
    }

    public int getCounterValue(){
        return counterValue;
    }

    public void setCounterValue(int newValue){
        this.counterValue = newValue;
    }

    public void resetCounter() {
        this.counterValue = this.initValue;
    }

    public void setName(String counterName) {
        this.counterName = counterName;
    }

    public String getName() {
        return counterName;
    }

    public String getComment(){
        return counterComment;
    }

    public void setComment(String counterComment) {
        this.counterComment = counterComment;
    }

    public String getDate(){return this.counterDate;}

    @Override
    public String toString(){
        String returnStr ="Counter name: " + getName()+"; Counter value: "+getCounterValue();
        return returnStr;}

    public boolean equals(Object compareCounter) {
        if (compareCounter != null &&
                compareCounter.getClass()==this.getClass()) {
            return this.equals((Counter)compareCounter);
        } else {
            return false;
        }
    }

    public boolean equals(Counter compareCounter) {
        if(compareCounter==null) {
            return false;
        }
        return getName().equals(compareCounter.getName());
    }
    public int hashCode() {
        return ("Student:"+getName()).hashCode();
    }
}


