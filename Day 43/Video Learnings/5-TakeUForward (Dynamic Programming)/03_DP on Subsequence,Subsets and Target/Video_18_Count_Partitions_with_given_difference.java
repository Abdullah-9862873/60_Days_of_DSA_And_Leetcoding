/*
Problem Statement
Given an array 'ARR', partition it into two subsets (possibly empty) such that their union is the original array. Let the sum of the elements of these two subsets be 'S1' and '2'. Given a difference 'D', count the number of partitions in which 'S1' is greater than or equal to 'S' and the difference between 'S1' and 'S2' is equal to 'D'. Since the answer may be too large, return it modulo '10^9 + 7. If 'Pi_Sj' denotes the Subset 'j' for Partition 'ї. Then, two partitions P1 and P2 are considered different if:
1) P1_$1 != P2_$1 i.e, at least one of the elements of P1_S1 is different from
P2_52.
2) P1_$1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2 _S2. Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed. Refer to the example below for clarification. Note that the sum of the elements of an empty subset is O.

For Example :
If N = 4, D = 3, ARR = {5, 2, 5, 1}
There are only two possible partitions of
this array.
Partition 1: {5, 2, 1}, {5}. The subset
difference between subset sum is: (5 + 2
+ 1) - (5) = 3
Partition 2: {5, 2, 1}, {5}. The subset
difference between subset sum is: (5 + 2
+ 1) - (5) = 3
These two partitions are different
because, in the 1st partition, S1
contains 5 from index 0, and in the 2nd
partition, S1 contains 5 from index 2.

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 50
0 ≤ D ≤ 2500
• ≤ ARR[i] ≤ 50
Time limit: 1 sec

Sample Input 1:
2
4 3
5 2 6 4
4 0
1111

Sample Output 1 :
1
6

*/
//__________________________________________________________
/*
Thought Process
Given that ----> S1 - S2 = D   --- (i)
we know that s1 + s2 = totalSum
totalSum-s2 = s1

Putting in (i)
totalSum-s2-s2 = D
totalSum-D = 2s2
(totalSum-D)/2 = s2

So we have to find the number of s2's which are equal to (totalSum-D)/2 

So we can copypaste the Video_17... But there are some edge cases that totalSum-D >=0 and since there are no fractions so (totalSum-D)/2 must be even

*/

// If I want to handle the cases in which the array may contain 0's then I have
// to add some test cases in the recursion and that test cases will be

/*
if(index == 0){
    if(k==0 && arr[index] == 0){
// I have two options both of them will be correct in this case so I return 2
// because 0 if added or not added does not effects
        return 2;
    }
    else if(k==0){
        return 1;
    }
    else if(k == arr[arr.length-1]){
        return 1;
    }else{
        return 0;
    }
}
*/

//______________________________________________________
// Using memoization
// import java.util.*;

// public class Video_18_Count_Partitions_with_given_difference {
//     public static void main(String[] args) {
//         int[] arr = { 5, 2, 6, 3 };
//         int D = 3;

//         int ans = countPartitions(arr, D);
//         System.out.println(ans);
//     }

//     public static int countPartitions(int[] arr, int D) {
//         int totalSum = 0;
//         for (int i = 0; i < arr.length; i++) {
//             totalSum += arr[i];
//         }
//         if (totalSum - D < 0 || totalSum - D % 2 == 0) {
//             return 0;
//         }
//         int ans = myFunc(arr, (totalSum - D) / 2);
//         return ans;

//     }

//     public static int myFunc(int[] arr, int k) {
//         int[][] dp = new int[arr.length][k + 1];
//         for (int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }

//         int ans = countSubsetsWithSumK(arr, 0, k, dp);
//         return ans;
//     }

//     public static int countSubsetsWithSumK(int[] arr, int index, int k, int[][] dp) {
//         if (index == 0) {
//             if (k == 0 && arr[index] == 0) {
//                 // I have two options both of them will be correct in this case so I return 2
//                 // because 0 if added or not added does not effects
//                 return 2;
//             }
//             if (k == 0) {
//                 return 1;
//             }
//             if (k == arr[arr.length - 1]) {
//                 return 1;
//             } else {
//                 return 0;
//             }
//         }
//         if (dp[index][k] != -1) {
//             return dp[index][k];
//         }

//         int ans1 = countSubsetsWithSumK(arr, index + 1, k, dp);
//         int ans2 = 0;
//         if (arr[index] <= k) {
//             ans2 = countSubsetsWithSumK(arr, index + 1, k - arr[index], dp);
//         }
//         return dp[index][k] = ans1 + ans2;
//     }
// }

// __________________________________________________________
// Using Tabulation

// public class Video_18_Count_Partitions_with_given_difference {
//     public static void main(String[] args) {
//         int[] arr = { 5, 2, 6, 3 };
//         int D = 3;

//         int ans = countPartitions(arr, D);
//         System.out.println(ans);
//     }

//     public static int countPartitions(int[] arr, int D) {
//         int totalSum = 0;
//         for (int i = 0; i < arr.length; i++) {
//             totalSum += arr[i];
//         }
//         if (totalSum - D < 0 || totalSum - D % 2 == 0) {
//             return 0;
//         }
//         int k = (totalSum - D) / 2;
//         int n = arr.length;
//         int[][] dp = new int[n + 1][k + 1];

//         if (arr[n - 1] == 0) {
//             dp[n - 1][0] = 2;
//         }
//         dp[n][0] = 1;

//         for (int i = n - 1; i >= 0; i--) {
//             for (int j = 0; j <= k; j++) {
//                 dp[i][j] = dp[i + 1][j];
//                 if (arr[i] <= j) {
//                     dp[i][j] += dp[i + 1][j - arr[i]];
//                 }
//             }
//         }

//         return dp[0][k];
//     }
// }

//_______________________________________________________
// Space Optimization

public class Video_18_Count_Partitions_with_given_difference {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 6, 3 };
        int D = 3;

        int ans = countPartitions(arr, D);
        System.out.println(ans);
    }

    public static int countPartitions(int[] arr, int D) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum - D < 0 || totalSum - D % 2 == 0) {
            return 0;
        }
        int k = (totalSum - D) / 2;
        int n = arr.length;
        int[] front = new int[k + 1];
        int[] curr = new int[k + 1];

        if (arr[n - 1] == 0) {
           front[0] = 2;
        }else{
            front[0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {
                curr[j] = front[j];
                if (arr[i] <= j) {
                    curr[j] += front[j - arr[i]];
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }

        return curr[k];
    }
}
