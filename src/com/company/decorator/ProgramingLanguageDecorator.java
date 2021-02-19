package com.company.decorator;

public abstract class ProgramingLanguageDecorator {

    ProgramingLanguageDecorator programingLanguageDecorator;

    public ProgramingLanguageDecorator() {
        printLangName();
    }

    public abstract void printLangName();

    public abstract void opportunities();

}
