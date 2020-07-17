package com.upai.manageallactivity.first;

import android.content.Context;

import com.upai.manageallactivity.second.SecondActivity;

class FirstModel {

    void switchToSecondActivity(Context context){
        SecondActivity.actionStart(context);
    }

}
