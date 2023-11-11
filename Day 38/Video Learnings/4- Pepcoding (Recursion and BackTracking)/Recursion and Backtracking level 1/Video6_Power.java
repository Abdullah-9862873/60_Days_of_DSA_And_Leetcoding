public class Video6_Power {
    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        int ans = calculatePower(x, n);
        System.out.println(ans);
    }
    public static int calculatePower(int x, int n){
        if(n == 1){
            return x;
        }
        return x * calculatePower(x, n-1);
    }
}
