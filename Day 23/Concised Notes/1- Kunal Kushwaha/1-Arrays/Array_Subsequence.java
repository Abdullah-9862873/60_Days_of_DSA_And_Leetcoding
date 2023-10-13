// Using power set algorithm

import java.util.*;
public class Array_Subsequence {
    public static void main(String[] args) {
        int[] arr = {1,9,3,10,4,20,2};
        printSubsequence(arr);
    }
    public static void printSubsequence(int[] arr){
        int n = arr.length;
        for(int i=0; i<Math.pow(2, n); i++){
            ArrayList<Integer> arraylist = new ArrayList<>();
            for(int j=0; j<arr.length; j++){
                if((i & 1<<j) != 0){
                    arraylist.add(arr[j]);
                }
            }
            System.out.println(arraylist);
        }
    }
}
