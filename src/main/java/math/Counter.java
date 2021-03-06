package math;

import util.StdOut;
import util.StdRandom;

/*
 *  Compilation:  javac Counter.java
 *  Execution:    java Counter n trials
 *  Dependencies: StdRandom.java StdOut.java
 *
 *  A mutable data type for an integer counter.
 *
 *  The test clients create n counters and performs trials increment
 *  operations on random counters.
 *
 * java Counter 6 600000
 *  100140 counter0
 *  100273 counter1
 *  99848 counter2
 *  100129 counter3
 *  99973 counter4
 *  99637 counter5
 * /

/**
 * The {@code Counter} class is a mutable data type to encapsulate a counter.
 * <p>
 * Created by iCrazyTeam on 2017/1/31.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class Counter implements Comparable<Counter> {

    private final String name;     // counter name
    private int count = 0;         // current value

    /**
     * Initializes a new counter starting at 0, with the given name.
     *
     * @param name the name of the counter
     */
    public Counter(String name) {
        this.name = name;
    }

    /**
     * Reads two command-line integers n and trials; creates n counters;
     * increments trials counters at random; and prints results.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // create n counters
        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("counter" + i);
        }

        // increment trials counters at random
        for (int t = 0; t < trials; t++) {
            hits[StdRandom.uniform(n)].increment();
        }

        // print results
        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }
    }

    /**
     * Increments the counter by 1.
     */
    public void increment() {
        count++;
    }

    /**
     * Returns the current value of this counter.
     *
     * @return the current value of this counter
     */
    public int tally() {
        return count;
    }

    /**
     * Returns a string representation of this counter.
     *
     * @return a string representation of this counter
     */
    public String toString() {
        return count + " " + name;
    }

    /**
     * Compares this counter to the specified counter.
     *
     * @param that the other counter
     * @return {@code 0} if the value of this counter equals
     * the value of that counter; a negative integer if
     * the value of this counter is less than the value of
     * that counter; and a positive integer if the value
     * of this counter is greater than the value of that
     * counter
     */
    @Override
    public int compareTo(Counter that) {
        if (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else return 0;
    }
}
