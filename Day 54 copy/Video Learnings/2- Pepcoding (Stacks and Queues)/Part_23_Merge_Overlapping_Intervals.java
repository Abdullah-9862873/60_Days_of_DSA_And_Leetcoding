/*
You are given intervals you have to merge them

Input:
22 28
1 8
25 27
14 19
27 30
5 12

Output:
1 12
22 30
14 19

*/

import java.util.*;

public class Part_23_Merge_Overlapping_Intervals {
    public static void main(String[] args) {
        int[][] arr = {
            {22,28},
            {1,8},
            {25,27},
            {14,19},
            {27,30},
            {5,12},
        };
        ArrayList<int[]> ans = new ArrayList<>();
        ans = mergeOverlappingIntervals(arr);
        for(int[] temp: ans){
            System.out.println(Arrays.toString(temp));
        }
    }
    public static ArrayList<int[]> mergeOverlappingIntervals(int[][] arr){
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for(int i=0; i<arr.length; i++){
            if(ans.isEmpty()){
                ans.add(arr[0]);
            }else{
                int[] lastArr = ans.get(ans.size()-1);
                int secondValOfInside = lastArr[1];     // 8
                int firstValOfIncoming = arr[i][0];     // 5
                if(firstValOfIncoming <= secondValOfInside){
                    int secondValOfIncoming = arr[i][1];        // 12
                    int firstValOfInside = lastArr[0];    // 1
                    if(secondValOfIncoming > secondValOfInside){
                        int[] newArr = new int[2];
                        newArr[0] = firstValOfInside;
                        newArr[1] = secondValOfIncoming;
                        ans.remove(ans.size()-1);
                        ans.add(newArr);
                    }
                }else{
                    ans.add(arr[i]);
                }
            }
        }
        return ans;

    }
}
