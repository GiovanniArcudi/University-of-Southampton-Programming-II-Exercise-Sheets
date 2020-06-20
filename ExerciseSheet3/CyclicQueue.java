/* EXERCISE:
   In this exercise you will write a circular queue data structure (see Wikipedia: Circular Buffer).

   Create a class CyclicQueue that implements NumberQueue (package uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading).
   Create a constructor that takes an integer parameter capacity. The capacity is the size of the queue.
   Use the parameter to initialise an integer array of the size of the provided capacity. You will also need two pointers:
   a head and a tail pointer. The head pointer points to where the front of the queue in the array currently is and the
   tail pointer points to where the back of the queue currently is.

   Now, implements the methods specified in the interface:

   - void enqueue(int): Insert a number to the back of the queue. If there is still space in the queue, move the tail
                        pointer and place the number into the associated array index.

    - int dequeue(): Remove and return the first number in the queue. Retrieve the number at the head pointer and update
                     the head pointer to indicate that this elements is not in the queue any more.

    - boolean isEmpty(): Returns true if the queue is empty. Determine from the pointers if there are still numbers in
                         the queue.

    Throw IndexOutOfBoundsException where appropriate.

    As you can see, you need to interact with the pointers for all three methods. The position and relation of the pointer
    will tell you if there are numbers in the queue and if you can remove or add numbers. */

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class CyclicQueue implements NumberQueue {
    private int[] queue;
    private int head = 0;
    private int tail = -1;
    private int elementsNumber = 0;

    // Class constructor
    public CyclicQueue(int capacity) {
        queue = new int[capacity];
    }

    // Insert a number to the back of the queue.
    // If there is still space in the queue, moves the tail pointer and place the number into the associated array index.
    @Override
    public void enqueue(int i) {
        if (head == (tail + 1) % queue.length && elementsNumber != 0) {
            throw new IndexOutOfBoundsException("The Circular Array is full!");
        } else {
            tail = (tail + 1) % queue.length;
            queue[tail] = i;
            elementsNumber++;
        }
    }

    // Removes and return the first number in the queue.
    // Retrieve the number at the head pointer and update the head pointer to indicate that this elements is not in the queue any more.
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The Circular Array is empty!");
        } else {
            int output = queue[head];
            head = (head + 1) % queue.length;
            elementsNumber--;
            return output;
        }
    }

    // Returns true if the queue is empty, false otherwise.
    @Override
    public boolean isEmpty() {
        return head == (tail + 1) % queue.length && elementsNumber == 0;
    }
}
