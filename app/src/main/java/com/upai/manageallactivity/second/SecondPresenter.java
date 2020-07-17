package com.upai.manageallactivity.second;

class SecondPresenter {

    private SecondView secondView;
    private SecondModel secondModel;

    SecondPresenter(SecondView view, SecondModel model) {
        secondView = view;
        secondModel = model;
    }

    void finishAll(){
        secondModel.finishAll();
        secondView.showToast("成功");
    }

}
