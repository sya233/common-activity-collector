package com.upai.manageallactivity.first;

import android.content.Context;

class FirstPresenter {

    private FirstView firstView;
    private FirstModel firstModel;

    FirstPresenter(FirstView view, FirstModel model) {
        firstView = view;
        firstModel = model;
    }

    void switchToSecondActivity(Context context){
        firstModel.switchToSecondActivity(context);
        firstView.showToast("跳转至SecondActivity");
    }

}
