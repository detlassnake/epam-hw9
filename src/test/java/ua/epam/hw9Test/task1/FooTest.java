package ua.epam.hw9Test.task1;

import org.junit.Before;
import org.junit.Test;
import ua.epam.hw9.task1.Foo;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FooTest {
    final String INTERRUPTED_EXCEPTION = "InterruptedException";
    ArrayList<String > input = new ArrayList<>();
    Foo foo = new Foo();
    Thread t1;
    Thread t2;
    Thread t3;

    @Before
    public void setUp() {
        (t1 = new Thread(() -> {
            try {
                foo.first(() -> input.add("first"));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();

        (t2 = new Thread(() -> {
            try {
                foo.second(() -> input.add("second"));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();

        (t3 = new Thread(() -> {
            try {
                foo.third(() -> input.add("third"));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();
    }

    @Test
    public void testFoo() {
        setUp();
        ArrayList<String> result = new ArrayList<>(Arrays.asList("first", "second", "third"));
        assertEquals(input, result);
    }
}