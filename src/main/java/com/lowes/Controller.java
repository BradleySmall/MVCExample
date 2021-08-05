package com.lowes;

public class Controller {
    private final Model model;
    private final View view;
     public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
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
