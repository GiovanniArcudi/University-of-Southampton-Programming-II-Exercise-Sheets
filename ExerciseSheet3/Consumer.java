/* EXERCISE:
   In this exercise you will use your queue to create a "number factory".

   Create the classes Producer and Consumer who both extend the class FactoryWorker (package uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading).
   For both of them, create a constructor with an int and a NumberQueue parameter.
   Use these parameters and the string "Consumer" or "Producer" to instantiate the class using the constructor of FactoryWorker.

   Following this, implement the two abstract methods and the run method:

   - void message(int): print a message with the job type, the id and the number to the console, e.g. "Consumer 5 picked 12345 from the belt."

   - int action(): For the producer generate a random number and add it to the queue. For the consumer take a number from the queue.

   - void run(): For both classes, the method should run as an infinite loop unless the thread gets interrupted
                 (HINT: Thread.currentThread().isInterrupted()). Moreover, the thread should try to perform an action
                 (call the respective action method) and if that fails should call messageError(). */

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Consumer extends FactoryWorker {

    public Consumer (int id, NumberQueue belt) {
        super("Consumer", id, belt);
    }

    @Override
    public void message(int i) {
        System.out.println("Consumer " + id + " picked " + belt + " from the belt.");
    }

    @Override
    public int action() {
        return belt.dequeue();
    }

    @Override
    public void run() {
        while (true) {
            while (!Thread.currentThread().isInterrupted()) {
                action();
            }
            messageError();
        }
    }
}
