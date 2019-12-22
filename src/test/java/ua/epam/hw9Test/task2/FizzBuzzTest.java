package ua.epam.hw9Test.task2;

import org.junit.Before;
import org.junit.Test;
import ua.epam.hw9.task2.FizzBuzz;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    final String INTERRUPTED_EXCEPTION = "InterruptedException";
    ArrayList<String> input = new ArrayList<>();
    FizzBuzz fizzBuzz = new FizzBuzz(15);
    Thread t1;
    Thread t2;
    Thread t3;
    Thread t4;

    @Before
    public void setUp() {
        (t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> input.add("fizz"));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();

        (t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> input.add("buzz"));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();

        (t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz(() -> input.add("fizzbuzz"));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();

        (t4 = new Thread(() -> {
            try {
                fizzBuzz.number(number -> input.add("" + number));
            } catch (InterruptedException e) {
                System.out.println(INTERRUPTED_EXCEPTION);
            }
        })).start();
    }

    @Test
    public void testFizzBuzz() {
        setUp();
        ArrayList<String> result = new ArrayList<>(Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "7", "8",
                "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"));
        assertEquals(input, result);
    }
}
