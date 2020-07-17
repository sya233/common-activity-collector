package com.upai.manageallactivity.main;

import android.content.Context;

class MainPresenter {

    private MainView mainView;
    private MainModel mainModel;

    MainPresenter(MainView view, MainModel model) {
        mainView = view;
        mainModel = model;
    }

    void switchToFirstActivity(Context context){
        mainModel.switchToFirstActivity(context);
        mainView.showToast("跳转至FirstActivity");
    }

}
