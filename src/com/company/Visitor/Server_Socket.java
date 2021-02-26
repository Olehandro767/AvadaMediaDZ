package com.company.Visitor;

public class Server_Socket extends ASocket {
    @Override
    public void work(SomeVisitor visitor) {
        visitor.doSomething();
    }
}