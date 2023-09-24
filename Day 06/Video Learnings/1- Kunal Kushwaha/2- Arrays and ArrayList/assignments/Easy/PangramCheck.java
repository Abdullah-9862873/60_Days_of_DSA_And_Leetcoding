import java.util.Arrays;

// A pangram is a sentence where every letter of the English alphabet appears at least once.

// Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

// Example 1:

// Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
// Output: true
// Explanation: sentence contains at least one of every letter of the English alphabet.

// Approach---->
/*
 * Run a loop from 97 to 122
 * 97 would be pointed as zero and 122 would be pointed as 26
 * declare a string array that has 26 values
 * make a for loop to initialise all the string array values to zero by default
 * 
 * make a for loop to traverse the
 */

public class PangramCheck {
    public static void main(String[] args) {
        boolean pangram = true;

        String sentence = "thequickbrownfoxjumpsoverthelazydog";

        boolean[] arr = new boolean[26];
        Arrays.fill(arr, false);

        for (int i = 0; i < sentence.length(); i++) {
            int asciiValAtChar = (sentence.charAt(i) - 'a');
            arr[asciiValAtChar] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) {
                pangram = false;
                break;
            }
        }

        System.out.println(pangram);
    }
}
