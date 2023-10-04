public class Video5_Print_Lexicographical_Order {
    public static void main(String[] args) {
        int n = 1000;
        printAns(n);
    }
    public static void printAns(int n){
        for(int i=1; i<=9; i++){
            dfs(i, n);
        }
    }
    public static void dfs(int i, int n){
        if(i > n){
            return;
        }
        System.out.print(i + " ");
        for(int j=0; j<=9; j++){
            dfs(10*i + j, n);
        }
    }
}
