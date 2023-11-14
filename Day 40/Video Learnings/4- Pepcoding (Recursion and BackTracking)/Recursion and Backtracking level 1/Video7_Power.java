public class Video7_Power {
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        int ans = calculatePower(x, n);
        System.out.println(ans);
    }
    // More optimized than Video 6
    public static int calculatePower(int x, int n){
        if(n == 0){
            return 1;
        }
        int nb2 = calculatePower(x, n/2);
        int mul = nb2*nb2;
        if(n % 2 == 1){
            mul = mul * x;
        }
        return mul;
    }
}
