public class Video_02_PrintIncreasing {
    public static void main(String[] args) {
        int n = 5;
        printIncreasing(n);
    }
    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
}


/*
-----> In the code where the recursion call is written... The code written above it will get called when recursion is going upward... And the code written down of it will get called when recursion is going downward
 */
