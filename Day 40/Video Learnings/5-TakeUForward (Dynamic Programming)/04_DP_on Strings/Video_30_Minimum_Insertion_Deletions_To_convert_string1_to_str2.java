public class Video_30_Minimum_Insertion_Deletions_To_convert_string1_to_str2 {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";

        // Get the longest common subsequence count
        int longestCommonStuff = getLongestCommonSubsequence(str1, str2);
        // We have to delete the remaining items from the str1 i-e 'b' and 'd' in this
        // case
        int deletions = str1.length() - longestCommonStuff;

        // We have to insert the remaining items from str2 into the remaining items
        // after deletion in str1... So remaining items after deletion in str1 will be
        // "ac" and we have to add 1 char into it i-e 'n' which is basically
        int insertions = str2.length() - longestCommonStuff;
        int totalOperations = deletions + insertions;
        System.out.println(totalOperations);
    }

    public static int getLongestCommonSubsequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    curr[j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
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
