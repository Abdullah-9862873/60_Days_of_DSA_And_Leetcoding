public class Video12_Tower_of_Hanoi{
    public static void main(String[] args){
        toh(3, 1, 2, 3);
        long ans = calcStep2(3, 1, 2, 3, 0);
        System.out.println(ans);
    }
    public static void toh(int n, int t1, int t2, int t3){
        if(n == 0){
            return;
        }

        toh(n-1, t1,t3, t2);
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        toh(n-1, t3, t2, t1);
    }

    public static long calcStepsOfTOH(int n, int t1, int t2, int t3){
        if( n==0){
            return 0;
        }
        long count = 0;
        count += calcStepsOfTOH(n-1, t1, t3, t2);
        count++;
        count += calcStepsOfTOH(n-1, t3, t2, t1);

        return count;
    }
    public static long calcStep2(int n, int t1, int t2, int t3, long count){
        if( n==0){
            return 0;
        }
        count += calcStepsOfTOH(n-1, t1, t3, t2);
        count++;
        count += calcStepsOfTOH(n-1, t3, t2, t1);

        return count;
    }
}