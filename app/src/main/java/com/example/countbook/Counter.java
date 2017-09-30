package com.example.countbook;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Saddog on 9/23/2017.
 */

public class Counter {
    private String counterName;
    private String counterDate;
    private int counterValue, initValue;
    private String counterComment;

    public Counter(String name, Integer initValue, String comment) {
        this.counterName = name;
        if (initValue >= 0) {
            this.counterValue = initValue;
        } else {
            throw new IllegalArgumentException("No negative number for counter value.");
        }
        ;
        this.initValue = initValue;
        this.counterComment = comment;
        this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    //@Override
    //Spublic String toString(){ return "";}

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

}

