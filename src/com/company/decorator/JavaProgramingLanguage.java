package com.company.decorator;

public class JavaProgramingLanguage extends ProgramingLanguageDecorator {

    ProgramingLanguageDecorator programingLanguageDecorator;

    public JavaProgramingLanguage(ProgramingLanguageDecorator programingLanguageDecorator) {
        super();
        this.programingLanguageDecorator = programingLanguageDecorator;
    }

    @Override
    public void printLangName() {
        System.out.println("Java");
    }

    @Override
    public void opportunities() {
        this.programingLanguageDecorator.opportunities();
        System.out.println("JVM");
        System.out.println("JNI");
        System.out.println("JRE");
    }
}
