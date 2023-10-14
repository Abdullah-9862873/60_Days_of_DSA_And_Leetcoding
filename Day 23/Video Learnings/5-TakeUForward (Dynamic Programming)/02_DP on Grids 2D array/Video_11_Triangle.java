/*
Problem Statement
You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row. The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements. You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j+ 1 in each step.

Constraints:
1 <= T <= 5
1 <= N <= 10^3
-10^6 <= TRIANGLE [i][pos] <= 10^6,
Where 'TRIANGLE[i][pos]' is the element
at row = 'i' & position = 'pos' in
triangle array.
Time limit: 1 sec

Sample Input 1 :
2
4
2
3 4
6 5 7
4 1 8 3
1
-10

Sample Output 1 :
11
-10

https://www.codingninjas.com/studio/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

*/

//______________________________________________________________
// Fixed Starting point and variable ending point

//______________________________________________________________
// Using Recursion
public class Video_11_Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
            {1},
            {2,3},
            {3,6,9},
            {8,9,6,10}
        };
        int ans = getMinPath(triangle, 0,0);
        System.out.println(ans);
    }
    public static int getMinPath(int[][] triangle, int rowStart, int colStart){
        if(rowStart == triangle.length-1){
            return triangle[rowStart][colStart];
        }

        int ans1 = triangle[rowStart][colStart] + getMinPath(triangle, rowStart+1, colStart);
        int ans2 = triangle[rowStart][colStart] + getMinPath(triangle, rowStart+1, colStart+1);
        return Math.min(ans1, ans2);
    }
    public static void printAllPaths(int[][] triangle, int rowStart, int colstart, String asf){
        if(rowStart == triangle.length-1){
            System.out.println(asf);
            return;
        }
        printAllPaths(triangle, rowStart+1, colstart, asf.isEmpty() ? "Down" : asf + "-" + "Down");
        printAllPaths(triangle, rowStart+1, colstart+1, asf.isEmpty() ? "Diagonal" : asf + "-" + "Diagonal");
    }
}

//______________________________________________________________
// Using Memoization
import java.util.*;
public class Video_11_Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
            {1},
            {2,3},
            {3,6,9},
            {8,9,6,10}
        };
        int[][] dp = new int[triangle.length][triangle.length];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }
        int ans = getMinPath(triangle, 0,0, dp);
        System.out.println(ans);
    }
    public static int getMinPath(int[][] triangle, int rowStart, int colStart, int[][] dp){
        if(rowStart == triangle.length-1){
            return dp[rowStart][colStart] = triangle[rowStart][colStart];
        }
        if(dp[rowStart][colStart] != -1){
            return dp[rowStart][colStart];
        }

        int ans1 = triangle[rowStart][colStart] + getMinPath(triangle, rowStart+1, colStart, dp);
        int ans2 = triangle[rowStart][colStart] + getMinPath(triangle, rowStart+1, colStart+1, dp);
        return dp[rowStart][colStart] = Math.min(ans1, ans2);
    }
}
//______________________________________________________________
// Using Tabulation
public class Video_11_Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
            {1},
            {2,3},
            {3,6,9},
            {8,9,6,10}
        };
        int ans = getMinPath(triangle, 0,0);
        System.out.println(ans);
    }
    public static int getMinPath(int[][] triangle, int rowStart, int colStart){
        int[][] dp = new int[triangle.length][triangle.length];
        int lengthOfLastRowOfTriangle = triangle[triangle.length-1].length;
        int lastRow = triangle.length-1;
        for(int i=0; i<lengthOfLastRowOfTriangle; i++){
            dp[lastRow][i] = triangle[lastRow][i];
        }

        int secondLastRow = triangle.length-2;
        for(int i=secondLastRow; i>=0; i--){
            for(int j=triangle[i].length-1; j>=0; j--){
                int ans1 = dp[i+1][j];
                int ans2 = dp[i+1][j+1];
                dp[i][j] = triangle[i][j] + Math.min(ans1,ans2);
            }
        }
        return dp[0][0];
    }
}

//______________________________________________________________
// Space Optimization
public class Video_11_Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
            {1},
            {2,3},
            {3,6,9},
            {8,9,6,10}
        };
        int ans = getMinPath(triangle, 0,0);
        System.out.println(ans);
    }
    public static int getMinPath(int[][] triangle, int rowStart, int colStart){
        int triangleLastRowSize = triangle[triangle.length-1].length;
        int[] dp = new int[triangleLastRowSize];
        for(int i=0; i<triangleLastRowSize; i++){
            dp[i] = triangle[triangleLastRowSize-1][i];
        }

        
        int secondLastRow = triangle.length-2;
        int totalElementsToChange = triangle.length-2;     
        for(int i=secondLastRow; i>=0; i--){        
            int[] temp = new int[triangleLastRowSize];
            for(int j=totalElementsToChange; j>=0; j--){        
                int ans1 = dp[j];
                int ans2 = dp[j+1];
                temp[j] = triangle[i][j] + Math.min(ans1,ans2);
            }
            totalElementsToChange -= 1;
            dp = temp;
        }
        return dp[0];
    }
}
