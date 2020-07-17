package com.upai.manageallactivity.main;

import android.content.Context;

import com.upai.manageallactivity.first.FirstActivity;

class MainModel {

    void switchToFirstActivity(Context context){
        FirstActivity.actionStart(context);
    }

}
