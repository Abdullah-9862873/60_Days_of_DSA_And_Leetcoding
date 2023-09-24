// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.

public class Sqrt {
    public static void main(String[] args) {
        int x = 128;

        long start = 0L;
        long end = Integer.MAX_VALUE;
        int ans = -1;

        while (start <= end) {
            long mid = (start) + (end - start) / 2;

            if (mid * mid <= x) {
                ans = (int) mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }
}