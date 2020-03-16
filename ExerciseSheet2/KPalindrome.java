/** EXERCISE:
   Write a Java program that checks if a String is k-palindrome or not.
   A String is k-palindrome if it becomes a palindrome on removing at most k characters from it.
   For example, ABCDEFCBA is a 2-palindrome since removing E and F results in ABCDCBA, which is a palindrome.

   Create the class KPalindrome which implements the interface PalindromeChecker
   (package uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion).
   Implement the isKPalindrome method to recursively determine if the passed string is a k-palindrome or not.
   Return true if the string is a k-palindrome and false otherwise. Do not use any loops.*/

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.PalindromeChecker;

public class KPalindrome implements PalindromeChecker {

    @Override
    public boolean isKPalindrome(String input, int k) {
        String reverseInput = new StringBuilder(input).reverse().toString();
        int stringLength = input.length();

        return (isKPalindromeAux(input, reverseInput, stringLength, stringLength) <= k * 2);
    }

    // Finds if the given string is K-Palindrome or not by recursively iterating over the input array and its reverse.
    public int isKPalindromeAux(String input, String reverseInput, int inputStringLength, int reverseInputStringLength) {

        // If first string is empty, the only option is to remove all characters of second string.
        if (inputStringLength == 0) {
            return reverseInputStringLength;
        }

        // If second string is empty, the only option is to remove all characters of first string.
        if (reverseInputStringLength == 0) {
            return inputStringLength;
        }

        // If last characters of two strings are same, ignore last characters and get count for remaining strings.
        if (input.charAt(inputStringLength - 1) == reverseInput.charAt(reverseInputStringLength - 1)) {
            return isKPalindromeAux(input, reverseInput,inputStringLength - 1, reverseInputStringLength - 1);
        }

        /* If last characters are not same:
           1. Remove last char from input and recur for (inputStringLength - 1) and reverseInputStringLength.
           2. Remove last char from reverseInput and recur for inputStringLength and (reverseInputStringLength - 1).
           Take minimum of above two operations */
        return 1 +
                Math.min(isKPalindromeAux(input, reverseInput, inputStringLength - 1, reverseInputStringLength), // Remove from input
                isKPalindromeAux(input, reverseInput, inputStringLength, reverseInputStringLength - 1)); // Remove from reverseInput
    }
}
