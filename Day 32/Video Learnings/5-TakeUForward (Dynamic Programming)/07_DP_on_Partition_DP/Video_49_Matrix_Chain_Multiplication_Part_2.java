//______________________________________________________________
// Using Tabulation

public class Video_49_Matrix_Chain_Multiplication_Part_2 {
    public static void main(String[] args) {
        int[] arr = { 10,30,5,60};
        int ans = getMinimalCost(arr);
        System.out.println(ans);
    }

    public static int getMinimalCost(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for(int i=0; i<arr.length; i++){
            dp[i][i] = 0;
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            // Now for j ideally you would have done opposite to recursion(j-1 --> 1) as (1
            // ---> j-1)
            // But this will make the j to the left of the i... But we have observed that j
            // will always be in the right side of i
            // So the jth loop will be from (i+1 ---> j-1)
            for (int j = i + 1; j <= arr.length - 1; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][arr.length-1];
    }
}

//_________________________________________________________
// Using Space Optimization

public class Video_49_Matrix_Chain_Multiplication_Part_2 {
    public static void main(String[] args) {
        int[] arr = { 10,30,5,60};
        int ans = getMinimalCost(arr);
        System.out.println(ans);
    }

    public static int getMinimalCost(int[] arr) {
        int[] front = new int[arr.length];
        int[] curr = new int[arr.length];
        
        
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + front[k] + front[j];
                    mini = Math.min(mini, steps);
                }
                front[j] = mini;
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return curr[arr.length-1];
    }
}