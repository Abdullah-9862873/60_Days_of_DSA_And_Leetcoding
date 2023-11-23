
/*
Problem Statement:
You have to buy on the minimum price and sell on the maximum... You cannot do something like buy on day 4 but sell on day 1... It has to be in order... You can buy at most K times and sell K times...
*/

//____________________________________________________________
// Method that has been used in Video 37

public class Video_38_Best_Time_To_Buy_And_Sell_Stocks_4 {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int K = 2;
        int ans = getMaxProfit(arr, K);
        System.out.println(ans);
    }

    public static int getMaxProfit(int[] arr, int K) {
        int[][] front = new int[2 + 1][K + 1];
        int[][] curr = new int[2 + 1][K + 1];

        // Base Cases

        for (int buy = 0; buy <= 1; buy++) {
            for (int buyCount = 0; buyCount <= K; buyCount++) {
                front[buy][buyCount] = 0;
            }
        }
        for (int index = 0; index < front.length; index++) {
            for (int buy = 0; buy <= 1; buy++) {
                front[buy][0] = 0;
            }
        }

        for (int index = arr.length - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int buyCount = 1; buyCount <= K; buyCount++) {
                    if (buy == 1) {
                        int ans1 = 0 + front[1][buyCount]; // Not bought
                        int ans2 = -arr[index] + front[0][buyCount]; // bought
                        curr[buy][buyCount] = Math.max(ans1, ans2);
                    } else {
                        int ans1 = 0 + front[0][buyCount]; // Not sold
                        int ans2 = arr[index] + front[1][buyCount - 1]; // sold
                        curr[buy][buyCount] = Math.max(ans1, ans2);
                    }
                }
            }
            front = curr;
        }
        return front[1][K];
    }
}
