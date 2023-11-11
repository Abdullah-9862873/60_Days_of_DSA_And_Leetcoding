public class Video4_Game_of_Execution {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int ans = lastManStanding(n, k);
        System.out.println(ans);
    }
    public static int lastManStanding(int n, int k){
        if(n == 1){
            return 0;
        }
        int x = lastManStanding(n-1, k);
        int y = (x+k)%n;
        return y;
    }
}
