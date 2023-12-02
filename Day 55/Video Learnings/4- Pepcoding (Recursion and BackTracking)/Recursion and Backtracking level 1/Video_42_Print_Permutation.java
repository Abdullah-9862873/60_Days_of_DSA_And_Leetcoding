public class Video_42_Print_Permutation {
    public static void main(String[] args) {
        printAns("abc", "");
    }
    public static void printAns(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i); // a
            String ros = str.replace(String.valueOf(ch), "");
            printAns(ros, ans+ch);
        }
    }
}
