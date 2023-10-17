/*
Problem Statement:
You have to buy on the minimum price and sell on the maximum... You cannot do something like buy on day 4 but sell on day 1... It has to be in order...
*/
public class Video_25_Best_Time_To_Buy_And_Sell_Stock{
    public static void main(String[] args) {
        int[] days = {7,1,5,3,6,4};
        int ans = getMaxProfit(days);
        System.out.println(ans);
    }
    public static int getMaxProfit(int[] days){
        int mini = days[0];
        int profit = 0;
        for(int i=1; i<days.length; i++){
            int cost = days[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, days[i]);
        }
        return profit;
    }
}

/*
It comes under dp because in this problem we are remembering the past...
*/