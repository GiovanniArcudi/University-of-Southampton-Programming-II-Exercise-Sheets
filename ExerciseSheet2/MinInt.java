/** EXERCISE:
   In this exercise you will write a Java application to recursively find the minimum in an array and in a tree.

   Firstly, even though you shouldn't write a program like this, just for practice, write a recursive method that will
   find the smallest element in an array of integers.

   Create a class MinInt that implements MinimumInArray (package uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion).
   Implement the method int findMin(int[]) to recursively find the minimum in the passed array.
   The method should return the minimal number in the array.*/

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.MinimumInArray;

public class MinInt implements MinimumInArray {

    public static void main(String[] numbers) {
        int[] arr = {24,52,74,9,34,23,64,34};
        MinInt minInt = new MinInt();
        System.out.println("Minimum is: " + minInt.findMin(arr));
    }

    public int findMin(int[] array) {
        return findMinAux(0, array);
    }

    public int findMinAux(int index, int[] array) {
        if (index == array.length) {
            return array[index-1];
        } else {
            if (array[index] < findMinAux(index + 1, array)) {
                return array[index];
            } else {
                return findMinAux(index + 1, array);
            }
        }
    }
}