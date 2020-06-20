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

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class Main {
    public static void main(String[] args) {

        NumberQueue numberQueue = new CyclicQueue(5);

        Producer producer1 = new Producer(1, numberQueue);
        Producer producer2 = new Producer(2, numberQueue);
        Producer producer3 = new Producer(3, numberQueue);
        Producer producer4 = new Producer(4, numberQueue);

        Consumer consumer1 = new Consumer(1, numberQueue);
        Consumer consumer2 = new Consumer(2, numberQueue);
        Consumer consumer3 = new Consumer(3, numberQueue);
        Consumer consumer4 = new Consumer(4, numberQueue);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(producer4).start();

        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
        new Thread(consumer4).start();
    }
}
