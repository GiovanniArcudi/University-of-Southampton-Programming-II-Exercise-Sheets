/* EXERCISE:
   In this exercise you will create a counter for a zoo to see how many guests have visited.

   Create a class Counter which implements the interface UnitCounter (package uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading).
   The class should have an int class variable for the counter. Implement the interface's methods: addOne has to add one
   to the counter variable and getCounter has to return the current value.

   Create a second class called Gate which implements Runnable. The class needs a constructor that has two parameters.
   The first one is a Counter and the second one is an int representing the number of guests visiting via the gate.
   Implement the run method to call the addOne method as many times as the specified number of guests.

   Finally, create a class Zoo with a main method. In the main method you should create one Counter and several Gates.
   Run all of the gates as threads and wait for them to finish (HINT: consider the join() method).
   After the threads have finished, print the number of expected guests and the state of the counter.
   If you have enough gates and high numbers of guests the two numbers should differ. */

public class Gate implements Runnable {
    Counter counter;
    int visitorsNumber;

    public Gate (Counter counter, int visitorsNumber) {
        this.counter = counter;
        this.visitorsNumber = visitorsNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < visitorsNumber; i++) {
            counter.addOne();
        }
    }
}
