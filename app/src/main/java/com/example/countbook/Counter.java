package com.example.countbook;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Saddog on 9/23/2017.
 */

public class Counter {
    private String counterName;
    private String counterDate;
    private int counterValue,initValue;
    private String counterComment;

    public Counter(String name, char initValue, String comment){
        this.counterName = name;
        if(initValue>0){this.counterValue = initValue;}else{System.exit(1);};
        this.initValue = initValue;
        this.counterComment = comment;
        this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public int incrementCounter(){
        this.counterValue++;
        this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return counterValue;
    };

    public int decrementCounter(){
        if(this.counterValue-1<0){System.exit(1);}
        else{
            this.counterValue--;
            this.counterDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return counterValue;
    }
    public void resetCounter(){
        this.counterValue = this.initValue;
    }

    public void editName(String counterName){
        this.counterName = counterName;
    }

    public void editComment (String counterComment) {
        this.counterComment = counterComment;
    }


}

