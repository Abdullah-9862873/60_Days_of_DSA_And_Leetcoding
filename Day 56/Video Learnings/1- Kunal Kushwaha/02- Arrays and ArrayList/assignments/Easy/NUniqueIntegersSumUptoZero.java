// Given an integer n, return any array containing n unique integers such that they add up to 0.

// Example 1:

// Input: n = 5
// Output: [-7,-1,1,3,4]
// Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

package newAssignments;

public class NUniqueIntegersSumUptoZero {
    public static void main(String[] args) {
        int n = 7;

        int[] ans = new int[n];

        if (n == 1) {
            ans[0] = 0;
        } else if (n % 2 != 0) {
            // It is odd
            ans[0] = 0;
            int j = 1;
            for (int i = 1; i < n; i += 2) {
                ans[i] = j;
                ans[i + 1] = -j;
                j += 1;
            }
        } else if (n != 1 && n % 2 == 0) {
            int j = 1;
            for (int i = 0; i < n; i += 2) {
                ans[i] = j;
                ans[i + 1] = -j;
                j += 1;
            }
        }

        for (int a : ans) {
            System.out.println(a);
        }
    }
}
