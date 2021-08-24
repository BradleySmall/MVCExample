package com.small.mvcexample;

import java.io.Serializable;

public record Controller(Model model, View view) implements Serializable {

    public void addObserver(Observer observer) {
        model.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        model.removeObserver(observer);
    }

    public void checkNewData() {
        model.nextData();
        view.showViewData(model.getCurrentData());
    }
}
