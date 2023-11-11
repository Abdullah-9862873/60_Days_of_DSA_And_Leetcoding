/*
Problem Statement
You have been given a number of stairs. Initially, you are at the Oth stair, and you need to reach the Nth stair. Each time you can either climb one step or two steps. You are supposed to return the number of distinct ways in which you can climb from the Oth step to Nth step.
Example:
Sample Input 1 :
2
2
3
Sample Output 1 :
2
3


Constraints :
1 ‹= 'T' ‹= 10
0 ‹= 'N' ‹= 10^5
Where 'T' is the number of test cases,
and 'N' is the number of stairs.
It is guaranteed that sum of 'N' over all
test cases is ‹= 10^5.

https://www.codingninjas.com/studio/problems/count-ways-to-reach-nth-stairs_798650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
*/
//_____________________________________________________________________________
// Memoization
public class Video_02_Climb_Stairs {
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
