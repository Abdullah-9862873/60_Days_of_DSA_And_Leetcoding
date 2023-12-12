import java.util.*;
public class Video_16_Word_Break {
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("micro");
        dict.add("soft");
        dict.add("hi");
        dict.add("ring");
        dict.add("microsoft");
        dict.add("hiring");

        String str2 = "microsofthiring";
        printWordBreak(dict, str2, "");
    }
    public static void printWordBreak(HashSet<String> dict, String str2, String asf){
        if(str2.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<str2.length(); i++){
            String first = str2.substring(0, i+1);
            String restOfStr2 = str2.substring(i+1);

            if(dict.contains(first)){
                printWordBreak(dict, restOfStr2, asf+first+"-");
            }
        }
    }
}
