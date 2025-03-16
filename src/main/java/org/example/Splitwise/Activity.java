package org.example.Splitwise;

import java.util.Date;

public class Activity {
    String message;
    Date activityDate;

    public Activity(String message, Date activityDate) {
        this.message = message;
        this.activityDate = activityDate;
    }
    @Override
    public String toString(){
        return "Activity:  "+activityDate.toString()+" "+message+" ";
    }
}
