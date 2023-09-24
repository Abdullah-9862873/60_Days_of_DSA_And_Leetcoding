public class ArrangeCoins {
    public static void main(String[] args) {
        int num = 1804289383;
        int ans = findArrangeCoinsAnswer(num);
        System.out.println(ans);
    }

    public static int findArrangeCoinsAnswer(int num) {
        int start = 1;
        int end = num;
        int ans = -1;
    
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long val = ((long) mid * (mid + 1)) / 2; 
            if (val <= num) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
