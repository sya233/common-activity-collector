package com.upai.manageallactivity.util;

import android.app.Activity;

import java.util.Stack;

public class ActivityUtil {

    private static Stack<Activity> stack;
    private static ActivityUtil manager;

    public static synchronized ActivityUtil getInstance(){
        if (manager==null){
            manager=new ActivityUtil();
            stack=new Stack<>();
        }
        return manager;
    }

    public synchronized void addActivity(Activity activity){
        stack.add(activity);
    }

    public synchronized void removeActivity(Activity activity){
        stack.remove(activity);
    }

    public void finishActivity(Activity activity){
        if (activity!=null){
            activity.finish();
            stack.remove(activity);
        }
    }

    public void finishAllActivity(){
        for (Activity activity:stack){
            if (activity!=null){
                activity.finish();
            }
        }
        stack.clear();
    }

}
