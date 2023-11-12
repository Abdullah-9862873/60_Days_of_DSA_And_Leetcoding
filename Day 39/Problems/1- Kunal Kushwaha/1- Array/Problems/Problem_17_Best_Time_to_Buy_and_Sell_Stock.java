
public class Problem_17_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 4, 5, 9, 7};
        int ans = findAns(arr);
        System.out.println(ans);
    }
    public static int findAns(int[] arr){
        int minCost = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int price = arr[i];

            minCost = Math.min(price, minCost);
            
            int curr_Profit = price - minCost;

            maxProfit = Math.max(maxProfit, curr_Profit);
        }
        return maxProfit;
    }
}
