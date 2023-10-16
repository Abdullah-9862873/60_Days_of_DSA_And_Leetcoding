/*
1- Start with the input string "abc" and its length, which is n = 3.

21- Iterate from i = 0 to i = 2^n - 1, where 2^n represents the total number of possible subsequences.

3- Inside the loop, create an empty StringBuilder to build the current subsequence.

4- Use another nested loop to iterate over each character of the input string "abc".

5- Check whether the j-th bit of i is set using bitwise AND (i & (1 << j)). If it's set (i.e., not equal to 0), append the character at index j from the input string to the StringBuilder.

6- After processing all characters in the inner loop, print the current subsequence.

7- Repeat this process for all possible values of i, which correspond to different combinations of characters from the input string.

___________________________________________________________
Checking if it is set
Following is the i from 0 till less than Math.pow(2,n)

0 ----> 0 0 0
1 ----> 0 0 1
2 ----> 0 1 0
3 ----> 0 1 1
4 ----> 1 0 0
5 ----> 1 0 1
6 ----> 1 1 0
7 ----> 1 1 1

1 << 0 gives 001.
1 << 1 gives 010.
1 << 2 gives 100

now when we do 000 & 001 ... it will give 000 that means pick up nothing from the str
When we de 001 & 001 ... It will give 001 which means pick up the 0th index from str which is "a"

And so on

 */
public class Power_Set {
    public static void main(String[] args) {
        String str = "abc";
        printSubsequence(str);
    }

    public static void printSubsequence(String str) {
        int n = str.length();
        for (int i = 0; i < Math.pow(2,n); i++) {
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if ((i & (1 << j)) != 0) {
                    ans.append(str.charAt(j));
                }
            }
            System.out.println(ans);
        }
    }
}