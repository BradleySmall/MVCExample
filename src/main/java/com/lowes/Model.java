package com.lowes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private List<Observer> observers = new ArrayList<>();
    private String currentData;
    private String data = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private Random rnd = new Random();
    Model() {
        nextData();
    }
    void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    void nextData() {
        int begin = rnd.nextInt(data.length() - 50) + 1;
        setCurrentData(data.substring(begin, begin + 50));
    }

    public void setCurrentData(String data) {
        currentData = data;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(currentData);
        }
    }

    public String getCurrentData() {
        return currentData;
    }
}
