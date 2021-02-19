package com.company.decorator;

public class CppProgramingLanguage extends ProgramingLanguageDecorator {

    public CppProgramingLanguage() {
        super();
    }

    @Override
    public void printLangName() {
        System.out.println("C++");
    }

    @Override
    public void opportunities() {
        System.out.println("OOP");
    }
}
