/*
//__________________________________________________________________________
When will you say that this particular question relates to Partition DP???
----> Lets take an example that you are given a problem     
1+2+3x5

Now this problem can be solved in two different ways
(1+2+3)x5
(1+2)+(3x5)

Both of these ways gives different answer... So whenever you observe a pattern in which solving different partition first gives different answers then you can say that the particular problem is of partition dp...

There can be multiple partitions like
(1)+(2+3x5)
(1+2)+(3x5)
(1+2+3)x(5)


//__________________________________________________________________________
Problem Statement:
Given the N matrix dimensions print the minimal cost to multiply them...
For Example:

If we have three matrixes A(10x30), B(30x5), C(5x60)

There can be two ways to multiply them
(AB)C
(A)(BC)

---> In case of (AB)C
if we multiply A with B then a new matrix of (10 x 5) will be generated and total operations performed will be (10 x 30 x 5) = 1500
And if we multiply the resultant matrix (10 x 5) with C(5 x 60) then resultant matrix formed wil be (10 x 60) and total operations or cost performed will be (10 x 5 x 60) = 3000

Total Cost = 1500 + 3000 = 4500

---> In case of (A)(BC)
Total cost = 9000 + 18000 = 27000

Minimal of them is 4500 which is your answer

Note----> Matrix can only be multiplied if columns of first matrix are same as the rows of the second matrix

//__________________________________________________________________________
You will be given an array
arr = {10,20,30,40,50}

Now in here you can say that there are 4 matrixes i-e basically arr.length() - 1

So dimension of each of the matrix will be arr[i-1] x arr[i]

Matrix 1 Dimension ---------> 10 x 20
Matrix 2 Dimension ---------> 20 x 30
Matrix 3 Dimension ---------> 30 x 40
Matrix 4 Dimension ---------> 40 x 50

//__________________________________________________________________________
Following are the steps to follow in order to solve DP on partitions

Step 1--------> Start with the entire block/array and mark them with (i,j) where i is the starting point of the block and j is the entring point of the block

Step 2--------> Try out all partitions... Run a loop to try out them

Step 3--------> Return the best possible 2 partitions
//__________________________________________________________________________

*/

//__________________________________________________________________________
// Using Recursion

public class Video_48_Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        int[] arr = {10,30,5,60};
        int ans = getMinimalCost(arr, 1, arr.length - 1);
        System.out.println(ans);
    }

    public static int getMinimalCost(int[] arr, int i, int j) {
        if (i == j) {
            // I only have one matrix... So the cost will be 0
            return 0;
        }
        int mini = Integer.MAX_VALUE;

        // Exploring all the partitions
        for (int k = i; k < j; k++) {
            int steps = (arr[i-1] * arr[k] * arr[j]) + getMinimalCost(arr, i, k) + getMinimalCost(arr, k + 1, j); 
            mini = Math.min(mini, steps);
        }
        return mini;
    }
}

//__________________________________________________________________________
// Using Memoization

import java.util.*;
public class Video_48_Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        int[] arr = {10,30,5,60};
        int[][] dp = new int[arr.length][arr.length];
        for(int[] temp: dp){
            Arrays.fill(temp,-1);
        }
        int ans = getMinimalCost(arr, 1, arr.length - 1,dp);
        System.out.println(ans);
    }

    public static int getMinimalCost(int[] arr, int i, int j,int[][] dp) {
        if (i == j) {
            // I only have one matrix... So the cost will be 0
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;

        // Exploring all the partitions
        for (int k = i; k < j; k++) {
            int steps = (arr[i-1] * arr[k] * arr[j]) + getMinimalCost(arr, i, k,dp) + getMinimalCost(arr, k + 1, j,dp); 
            mini = Math.min(mini, steps);
        }
        return dp[i][j] = mini;
    }
}