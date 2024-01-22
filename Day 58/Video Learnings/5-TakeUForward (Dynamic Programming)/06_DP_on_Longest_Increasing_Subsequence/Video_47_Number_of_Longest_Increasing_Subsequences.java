/*
Problem Statement:
You are given an array, for example
arr = {1,3,5,4,7}

You have to tell me how many times does the longest increasing subsequence came in the array... For example if we take this array then there are two possible longest increasing subsequences:
{1,3,5,7}
{1,3,4,7}

So since there are two of them... You have to return 2

//______________________________________________________
Thought Process:

-----> We can maintain a count array with the dp array... And lets say if my ith index of my dp array is 4 which indicates that till the ith index the LIS(Longest Increasing Subsequence) is what... Lets say my ith index is 3 of the dp array which indicates that till the ith the LIS is 4... Now when I again get 3 i-e when there is another LIS present till the ith index that gives me 4 LIS... Then I have to increase the count to +1... This is the idea...

 */
public class Video_47_Number_of_Longest_Increasing_Subsequences {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        int ans = getNoOfLIS(arr);
        System.out.println(ans);
    }
    public static int getNoOfLIS(int[] arr){
        int[] dp = new int[arr.length];
        int[] count = new int[arr.length];

        int maxi = 1;

        for(int i=0; i<arr.length; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int prev=0; prev<i; prev++){
                if(arr[i] > arr[prev] && 1+dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                }else if(1+dp[prev] == dp[i]){
                    count[i] = count[prev] + 1;
                    maxi = Math.max(maxi,count[i]);
                }
            }
        }
        
        return maxi;
    }
}
