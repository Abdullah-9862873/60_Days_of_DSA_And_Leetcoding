// Recursion Method 1
import java.util.*;

public class Video5_Maximum_sum_of_non_adjacent_elements {
    public static void main(String[] args) {
        String str = "2149";
        ArrayList<String> subSequenceList = getSubsequenceOfNonAdjacentElements(str, str);
        int ans = maxSum(subSequenceList);
        System.out.println(ans);
    }
    public static int maxSum(ArrayList<String> subsequence){
        int max = Integer.MIN_VALUE;
        for(String temp : subsequence){
            if(temp.length() == 1){
                if(temp.charAt(0)-'0' > max){
                    max = temp.charAt(0)-'0';
                }
            }else if(temp.length() > 1){
                int sumOfChars = 0;
                for(int i=0; i<temp.length(); i++){
                    sumOfChars += temp.charAt(i)-'0';
                }
                if(sumOfChars > max){
                    max = sumOfChars;
                }
            }
        }
        return max;
    }

    public static ArrayList<String> getSubsequenceOfNonAdjacentElements(String str, String original) {
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        char ch = str.charAt(0);
        String sub = str.substring(1);
        ArrayList<String> recResponse = getSubsequenceOfNonAdjacentElements(sub, original);

        ArrayList<String> ans = new ArrayList<>();
        for (String temp : recResponse) {
            ans.add("" + temp);
            if (original.contains(temp)) {
                int indexOfTemp = original.indexOf(temp);
                int indexOfCh = original.indexOf(ch);
                if (!temp.isEmpty() && ((indexOfTemp > 0 && indexOfCh == indexOfTemp-1)
                        || (indexOfTemp < original.length() - 1 && indexOfCh == indexOfTemp+1))) {
                    continue;
                } else {
                    ans.add(ch + temp);
                }
            }
        }
        return ans;
    }
}

//____________________________________________________________________________
// Rectursion Method 2

public class Video5_Maximum_sum_of_non_adjacent_elements{
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int ans = getMaxSumOfNonAdjacentSubSequences(arr, arr.length-1);
        System.out.println(ans);
    }
    public static int getMaxSumOfNonAdjacentSubSequences(int[] arr, int index){
        if(index == 0){
            return arr[index];
        }
        if(index < 0){
            return 0;
        }

        // Pick
        int ans1 = arr[index] + getMaxSumOfNonAdjacentSubSequences(arr, index-2);

        // Not Pick
        int ans2 = 0 + getMaxSumOfNonAdjacentSubSequences(arr, index-1);

        return Math.max(ans1, ans2);
    }
}

//___________________________________________________________________
// Using Memoization
import java.util.*;
public class Video5_Maximum_sum_of_non_adjacent_elements{
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        int ans = getMaxSumOfNonAdjacentSubSequences(arr, arr.length-1, dp);
        System.out.println(ans);
    }
    public static int getMaxSumOfNonAdjacentSubSequences(int[] arr, int index, int[] dp){
        if(index == 0){
            return arr[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }

        // Pick
        int ans1 = arr[index] + getMaxSumOfNonAdjacentSubSequences(arr, index-2, dp);

        // Not Pick
        int ans2 = 0 + getMaxSumOfNonAdjacentSubSequences(arr, index-1, dp);

        return dp[index] = Math.max(ans1, ans2);
    }
}

// Time Complexity ----> O(n)
// Space Complexity ---> O(n) + O(n)

//________________________________________________________________________________
// Using Tabulation
public class Video5_Maximum_sum_of_non_adjacent_elements{
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int ans = getMaxSumOfNonAdjacentSubSequences(arr);
        System.out.println(ans);
    }
    public static int getMaxSumOfNonAdjacentSubSequences(int[] arr){
        int n = arr.length;
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            // pick
            int pick = arr[i];
            if(i > 1){
                pick += dp[i-2];
            }
            // not pick
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }   

        return dp[n-1];
    }
}

//________________________________________________________________________________
// Space Optimization
public class Video5_Maximum_sum_of_non_adjacent_elements{
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int ans = getMaxSumOfNonAdjacentSubSequences(arr);
        System.out.println(ans);
    }
    public static int getMaxSumOfNonAdjacentSubSequences(int[] arr){
        int n = arr.length;
        if(n == 0){
            return 0;
        }

        int prev = arr[0];
        int prev2 = 0;
        for(int i=1; i<n; i++){
            // pick
            int pick = arr[i];
            if(i > 1){
                pick += prev2;
            }
            // not pick
            int notPick = 0 + prev;
            int current = Math.max(pick,notPick);
            prev2 = prev;
            prev = current;
        }   

        return prev;
    }
}