public class Video13_Palindromic_Partitioning_Of_String {
    public static void main(String[] args) {
        String str = "abaaba";
        printPalindromicPartitions(str, "");
    }
    public static void printPalindromicPartitions(String str, String asf){
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String myString = str.substring(0, i+1);
            String ros = str.substring(i+1);
            if(isPalindromic(myString)){
                printPalindromicPartitions(ros, asf + "(" + myString + ") ");
            }
        }
    }
    public static boolean isPalindromic(String str){
        int start = 0;
        int end = str.length()-1;

        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}

// Every partition should itself be palindromic
