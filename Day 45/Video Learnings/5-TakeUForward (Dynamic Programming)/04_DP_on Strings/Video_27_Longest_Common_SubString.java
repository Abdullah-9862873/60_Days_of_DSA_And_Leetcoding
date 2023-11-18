//__________________________________________________________________________
// Using the tabulation approach of video 25 to make dp 

// public class Video_27_Longest_Common_SubString {
    //     public static void main(String[] args) {
        //         String s1 = "acxd";
        //         String s2 = "xacd";
        
        //         int ans = getLongestCommonSubString(s1,s2);
        //         System.out.println(ans);
        //     }
        //     public static int getLongestCommonSubString(String s1, String s2){
            //         int[][] dp = new int[s1.length()+1][s2.length()+1];
            
//         int maxi = Integer.MIN_VALUE;

//         for(int i=s1.length(); i>=0; i--){
//             for(int j=s2.length(); j>=0; j--){
//                 if(i==s1.length() || j==s2.length()){
//                     dp[i][j] = 0;
//                 }else if(s1.charAt(i) == s2.charAt(j)){
    //                     dp[i][j] = 1 + dp[i+1][j+1];
    //                     maxi = Math.max(maxi, dp[i][j]);
//                 }
//             }
//         }

//         return maxi;
//     }
// }

//__________________________________________________________________________
// Using Space optimization

public class Video_27_Longest_Common_SubString {
    public static void main(String[] args) {
        String s1 = "acxd";
        String s2 = "xacd";

        int ans = getLongestCommonSubString(s1,s2);
        System.out.println(ans);
    }
    public static int getLongestCommonSubString(String s1, String s2){
        int[] front = new int[s1.length()+1];
        int[] curr = new int[s1.length()+1];

        int maxi = Integer.MIN_VALUE;

        for(int i=s1.length(); i>=0; i--){
            for(int j=s2.length(); j>=0; j--){
                if(i==s1.length() || j==s2.length()){
                    curr[j] = 0;
                }else if(s1.charAt(i) == s2.charAt(j)){
                    curr[j] = 1 + front[j+1];
                    maxi = Math.max(maxi, curr[j]);
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }

        return maxi;
    }
}