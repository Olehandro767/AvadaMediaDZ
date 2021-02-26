package com.company;

import com.company.ChainOfResponsibility.FirstNotifier;
import com.company.ChainOfResponsibility.Priority;
import com.company.ChainOfResponsibility.SecondNotifier;
import com.company.ChainOfResponsibility.ThirdNotifier;
import com.company.Command.*;
import com.company.Interpreter.Evaluate;
import com.company.Interpreter.Expression;
import com.company.Iterator.Iterator;
import com.company.Iterator.OS;
import com.company.Mediator.Mediator;
import com.company.Mediator.Person1;
import com.company.Memento.CareTaker;
import com.company.Memento.Originator;
import com.company.Observer.Observer;
import com.company.State.Human;
import com.company.State.RestState;
import com.company.Strategy.BubbleSort;
import com.company.Strategy.QuickSort;
import com.company.Strategy.StrategyClient;
import com.company.TemplateMethod.ConsoleLog;
import com.company.TemplateMethod.FileLog;
import com.company.TemplateMethod.Log;
import com.company.Visitor.ASocket;
import com.company.Visitor.Client_Socket;
import com.company.Visitor.Server_Socket;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Template Method
        System.out.println("Template Method:");
        Log log = new ConsoleLog();
        log.startLog();
        log = new FileLog();
        log.startLog();
        //Mediator
        System.out.println("\nMediator:");
        Mediator mediator = new Mediator();
        Person1 person1 = new Person1(mediator, "Oleg");
        Person1 person2 = new Person1(mediator, "Vova");
        mediator.addPerson(person1);
        mediator.addPerson(person2);
        mediator.notifyAll("Hi");
        //Chain of Responsibility
        System.out.println("\nChain of Responsibility:");
        FirstNotifier firstNotifier = new FirstNotifier(Priority.first);
        SecondNotifier secondNotifier = new SecondNotifier(Priority.second);
        firstNotifier.setChainOfResponsibility_notifier(secondNotifier);
        ThirdNotifier thirdNotifier = new ThirdNotifier(Priority.third);
        secondNotifier.setChainOfResponsibility_notifier(thirdNotifier);
        firstNotifier.sendMessage("text 1", Priority.first);
        firstNotifier.sendMessage("text 2", Priority.second);
        firstNotifier.sendMessage("text 3", Priority.third);
        //Observer
        System.out.println("\nObserver:");
        Observer observer = new Observer("first");
        Observer observer2 = new Observer("second");
        observer.setStatus("status 1");
        //Strategy
        System.out.println("\nObserver:");
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(100);
        StrategyClient strategyClient = new StrategyClient(new QuickSort());
        strategyClient.sortArr(arr);
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(100);
        strategyClient = new StrategyClient(new BubbleSort());
        strategyClient.sortArr(arr);
        //Command
        System.out.println("\nCommand:");
        DataBase dataBase = new DataBase();
        Client client = new Client(new SelectCommand(dataBase), new InsertCommand(dataBase), new UpdateCommand(dataBase), new DeleteCommand(dataBase));
        client.selectFromDB();
        client.insertFromDB();
        //State
        System.out.println("\nState:");
        RestState state = new RestState();
        Human human = new Human();
        human.setState(state);
        for (int i = 0; i < 4; i++)
            human.doSomething();
        //Visitor
        System.out.println("\nVisitor:");
        ASocket socket = new Client_Socket();
        socket.work(() -> System.out.println("Client is working"));
        socket = new Server_Socket();
        socket.work(() -> System.out.println("Server is working"));
        //Interpreter
        System.out.println("\nInterpreter:");
        Evaluate expression = new Evaluate("7+3+5");
        System.out.println(expression.interpreter(expression));
        //Iterator
        System.out.println("\nIterator:");
        OS os = new OS();
        Iterator iterator = os.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //Memento
        System.out.println("\nMemento:");
        Originator originator = new Originator();
        originator.setState("St 1");
        System.out.println(originator.getState());
        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.getMemento());
        originator.setState("St 2");
        System.out.println(originator.getState());
        originator.getDataFromMemento(careTaker.getMemento());
        System.out.println(originator.getState());
    }
}