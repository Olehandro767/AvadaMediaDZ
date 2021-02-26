package com.company.Visitor;

public class Client_Socket extends ASocket {
    @Override
    public void work(SomeVisitor visitor) {
        visitor.doSomething();
    }
}
