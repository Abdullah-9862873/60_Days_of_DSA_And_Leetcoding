/*
The question states that you are given a string and you have to return 0 if it is already a palindrome... And you have to return the minimum number of insertions of the characters in any part of the string in order to make the string palindrome... The question is not asking to print the string... It is just asking to return the minimum possible insertions of any characters at any part of the string to make it palindrome...

______________________________________________________________________________
Thought Process:
If we just figure out the longest common subsequence then we can do something like make the longest common subsequence intact and add the remaining characters in reverse order...

For Example...
If i have a string "abcaa"... Naive approach is to make it palindrome by adding the same string into it in reverse order like "abcaaaacba"... This will make the answer to be "
str.length()" but we have to get the minimum... 

We know that longest palindrome subsequence is "aaa" only the "bc" needs to get figured out... So can we add the bc in the reverse order somewhere to make it palindrome... Ofcourse we can... So the answer to this will be 2 because only 2 characters needs to get added at an appropriate place to make this string palindrome...
 */
public class Video_29_Minimum_Insertions_to_make_string_palindrome {
    public static void main(String[] args) {
        String str = "abcaa";
        int ans = str.length() - getLargestPalindromicSubsequence(str);
        System.out.println(ans);
    }

    public static int getLargestPalindromicSubsequence(String str) {
        // Finding the reverse of the string

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        String str2 = sb.toString();
        int ans = getLongestCommonSubsequence(str, str2);
        return ans;
    }

    public static int getLongestCommonSubsequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];
        
        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if(i == s1.length() || j == s2.length()){
                    curr[j] = 0;
                }
                else if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = 1 + front[j + 1];
                } else {
                    curr[j] = Math.max(front[j], curr[j + 1]);
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        
        return front[0];
    }
}
