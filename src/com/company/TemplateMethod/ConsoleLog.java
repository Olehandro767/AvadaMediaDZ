package com.company.TemplateMethod;

public class ConsoleLog extends Log {
    @Override
    public void log(String l) {
        System.out.println("printing to console -> " + l);
    }
}
