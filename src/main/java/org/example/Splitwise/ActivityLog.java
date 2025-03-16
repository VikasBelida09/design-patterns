package org.example.Splitwise;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActivityLog {
    private static final List<Activity> activityLog=new CopyOnWriteArrayList<>();;

    static void addActivity(String message){
        activityLog.add(new Activity(message, new Date()));
    }
    static void showActivityLogs(){
        System.out.println("#### Activity Log");
        for(Activity activity: activityLog){
            System.out.println(activity);
        }
    }
}
