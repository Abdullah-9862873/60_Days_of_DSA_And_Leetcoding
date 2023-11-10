public class Video5_PrintFactorial {
    public static void main(String[] args) {
        int n = printFactorial(5);
        System.out.println(n);
    }
    public static int printFactorial(int n){
        if(n == 1){
            return 1;
        }
        return n * printFactorial(n-1);
    }
}
