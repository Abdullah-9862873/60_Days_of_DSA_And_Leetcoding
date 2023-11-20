public class Video_03_PrintDecreasingIncreasing {
    public static void main(String[] args) {
        printDecInc(5);
    }
    public static void printDecInc(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);      
        printDecInc(n-1);  
        System.out.println(n);
    }
}
