package com.company.TemplateMethod;

public abstract class Log {

    public void startLog() {
        System.out.println("start log:");
        log("some log...");
    }

    protected abstract void log(String l);

}
