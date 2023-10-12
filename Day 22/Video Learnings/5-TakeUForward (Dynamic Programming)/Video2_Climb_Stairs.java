// Memoization
import java.util.*;
public class Video2_Climb_Stairs {
    public static void main(String[] args) {
        int n = 3;
        printAns(0,n,"");
    }
    public static void printAns(int initialSteps, int totalSteps,String asf){
        if(initialSteps >= totalSteps){
            if(initialSteps == totalSteps){
                System.out.println(asf.substring(0,asf.length()-1));
            }
            return;
        }

        printAns(initialSteps+1, totalSteps, asf+"1-");
        printAns(initialSteps+2, totalSteps, asf+"2-");      
    }
}

/*
Points to remember:
Step1. Identify a DP Problem.
Step2. To solve the problem after identification.
   1. Try to represent the given problem in terms of index.
   2. Do all possible operations on that index according to the problem statement.
   3. To count all possible ways - sum of all stuff.
        To find minimum/maximum - Take Minimum/maximum of all stuff.

___________________________________________________________
If out of all the possible ways you want to figure out
1) to count the number of possible ways
2) to find the best way
3) to find a particular pattern

We can simply use recursion no need to use DP
 */
