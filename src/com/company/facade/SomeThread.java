package com.company.facade;

import java.util.ArrayList;

public class SomeThread extends Thread {

    String string;

    public SomeThread(String s) {
        string = s;
    }

    @Override
    public void run() {
        System.out.println(string);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i < 4; i++)
            strings.add("string " + i);
        strings.forEach(s ->
                System.out.println(s));
    }
}
