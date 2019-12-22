package ua.epam.hw9.task2;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private final AtomicInteger counter;
    private final int n;

    public FizzBuzz(int n) {
        this.n = n;
        counter = new AtomicInteger(1);
    }

    private void updateToNext(int count) {
        if (!counter.compareAndSet(count, count + 1))
            throw new ConcurrentModificationException();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
                updateToNext(count);
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 == 0) {
                printBuzz.run();
                updateToNext(count);
            }
        }
    }

    public void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
                updateToNext(count);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                updateToNext(count);
            }
        }
    }
}

