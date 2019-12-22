package ua.epam.hw9.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private AtomicInteger i;

    public Foo() {
        i = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (!i.compareAndSet(1,2));
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!i.compareAndSet(2,3));
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!i.compareAndSet(3,4));
        printThird.run();
    }
}