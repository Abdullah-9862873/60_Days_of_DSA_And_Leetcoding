/*
We were solving the subsequence question such that when we had "abc" then the number of subsequence I we were getting are 2*3 = 8....
["", "a", "b", "c","ab","bc","ca", "abc"]

If we make pairs of the first and the last positions and then moving the first position ahead and moving the last position back... Then the pairs will be such that
["", "abc"] ["a","ca"] ["b","bc"] ["c", "ab"]

The number of pairs are ((2^3 / 2) = 4) or (2^(n-1) if n = 3)
The number of characters they are holding are (2^(n-1)*n)----> 2^(3-1) * 3 ---> 2^2 * 3 --> 4 * 3 = 12

if we have 31 characters at initial then the total number of subsequence characters will be
----> 2^(31-1) * 31
----> 2^30 * 31
----> (1024)^3 * 31
----> (10^3)^3 * 31
----> (10)^9 * 31
Each character takes 1 byte of memory then the total memory need to store these many characters are 31 * (10)^9 bytes ----> 31 gigabye
So this is the problem... We dont have that much Ram memory usually... So we need to change our strategy... Instead of storing the (bc) characters first and then making them changed for the (abc)... We'll keep on printing the characters as we get any subsequence...

 */
public class Video33_PrintSubsequence {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        printSubsequence(str, "");
    }
    public static void printSubsequence(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char firstChar = str.charAt(0);
        String ros = str.substring(1);
        printSubsequence(ros, ans + firstChar);
        printSubsequence(ros, ans + "");
    }
}
