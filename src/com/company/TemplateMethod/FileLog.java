package com.company.TemplateMethod;

public class FileLog extends Log {
    @Override
    public void log(String l) {
        System.out.println("echo to file lo -> " + l);
    }
}
