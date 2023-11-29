public class Video_01_Print_Abbreviations{
    public static void main(String[] args) {
        String input = "pep";
        printAbbreviations(input, "", 0);
    }
    public static void printAbbreviations(String str, String ans, int count){
        if(str.length() == 0){
            if(count!=0){
                System.out.println(ans + Integer.toString(count));
            }else{
                System.out.println(ans);
            }
            return;
        }

        if(count != 0){
            printAbbreviations(str.substring(1), ans + count + str.charAt(0), 0);
        }else{
            printAbbreviations(str.substring(1), ans + str.charAt(0), count);
        }
        printAbbreviations(str.substring(1), ans, count+1);
    }
}