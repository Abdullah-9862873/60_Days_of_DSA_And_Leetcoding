/*
Problem Statement:
You are given an array and you have to do like assign each element of the array a sign either positive or negative and after assigning them signs add them all... And they must be equal to the target... And you have to count such ways...
*/

/*
Thought Process:
If  have the array as [1,2,3,1] and I am assigning some values positive and some values negative like

+(2+3) - (1 + 1)

So what I am basically doing is taking a subset s1 from the array and taking another subset s2 from the array and then subtracting them as s1 - s2... And then it must be equal to the target... Isn't it same as the video 18 in which we were counting partition subsets with difference equal to the target...
*/
//_____________________________________________________________

public class Video_21_Target_sum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        int target = 3;

        int ans = countPartitions(arr, target);
        System.out.println(ans);
    }

    public static int countPartitions(int[] arr, int D) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum - D < 0 || totalSum - D % 2 == 0) {
            return 0;
        }
        int k = (totalSum - D) / 2;
        int n = arr.length;
        int[] front = new int[k + 1];
        int[] curr = new int[k + 1];

        if (arr[n - 1] == 0) {
            front[0] = 2;
        } else {
            front[0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {
                curr[j] = front[j];
                if (arr[i] <= j) {
                    curr[j] += front[j - arr[i]];
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }

        return curr[k];
    }
}