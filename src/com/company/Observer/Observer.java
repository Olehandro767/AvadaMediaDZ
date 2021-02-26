package com.company.Observer;

import java.util.ArrayList;

interface Observable {
    void update(String str);
}

public class Observer implements Observable {

    static ArrayList<Observer> observers = new ArrayList<>();
    private String name;
    private String status;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
        update("add new Observer");
    }

    public void setStatus(String status) {
        this.status = status;
        update("change status");
    }

    @Override
    public void update(String str) {
        for (Observer observer: observers) {
            System.out.println(observer.name + " " + observer.status + ": " + str);
        }
    }
}
