public class Problem_27_Maximum_profit_by_Buying_and_selling_a_share_at_most_twice{
    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        int ans = maxtwobuysell(arr, arr.length);
        System.out.println(ans);
    }
    public static int maxtwobuysell(int arr[],int size) {
        int first_buy = Integer.MIN_VALUE;
          int first_sell = 0;
          int second_buy = Integer.MIN_VALUE;
          int second_sell = 0;
           
          for(int i = 0; i < size; i++) {
             
              first_buy = Math.max(first_buy,-arr[i]);
              first_sell = Math.max(first_sell,first_buy+arr[i]);
              second_buy = Math.max(second_buy,first_sell-arr[i]);
              second_sell = Math.max(second_sell,second_buy+arr[i]);
           
        }
         return second_sell;
    }
}