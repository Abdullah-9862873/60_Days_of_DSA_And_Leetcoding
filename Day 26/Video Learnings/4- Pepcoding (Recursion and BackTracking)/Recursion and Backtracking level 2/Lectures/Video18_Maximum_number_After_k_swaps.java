public class Video18_Maximum_number_After_k_swaps {
    public static void main(String[] args) {
        String n = "1234567";
        int k = 4;
        String max = printMaxNumberAfterKSwaps(n, k);
        System.out.println(max);
    }

    public static String printMaxNumberAfterKSwaps(String n, int k) {
        String max = n;
        if (k == 0) {
            return max;
        }

        for(int i=0; i<n.length()-1; i++){
            for(int j=i+1; j<n.length(); j++){
                if(n.charAt(j) > n.charAt(i)){
                    n = swap(n, i, j);
                    String temp = printMaxNumberAfterKSwaps(n, k-1);
                    if(Integer.parseInt(temp) > Integer.parseInt(max)){
                        max = temp;
                    }
                    n= swap(n, i, j);
                }
            }
        }
        return max;
    }

    public static String swap(String str, int first, int second) {
        if (str == null || first < 0 || first > str.length() || second < 0 || second > str.length()) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        char temp = sb.charAt(first);
        sb.setCharAt(first, sb.charAt(second));
        sb.setCharAt(second, temp);

        return sb.toString();
    }
}
