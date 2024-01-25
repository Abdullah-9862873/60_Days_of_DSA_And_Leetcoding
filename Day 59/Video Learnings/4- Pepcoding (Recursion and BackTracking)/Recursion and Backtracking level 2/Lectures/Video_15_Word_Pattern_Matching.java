import java.util.*;

public class Video_15_Word_Pattern_Matching {
    public static void main(String[] args) {
        String str1 = "graphtreegraph";
        String str2 = "pep";
        String copy = str2;

        HashMap<Character, String> map = new HashMap<>();
        printWordPatterns(str1, str2, map, copy);
    }

    public static void printWordPatterns(String str1, String str2, HashMap<Character, String> map, String originalPattern) {
        if(str2.length() == 0){
            if(str1.length() == 0){
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for(int i=0; i<originalPattern.length(); i++){
                    char ch = originalPattern.charAt(i);
                    if(!alreadyPrinted.contains(ch)){
                        System.out.println(ch + " -> " + map.get(ch));
                        alreadyPrinted.add(ch);
                    }
                }
            }
            return;
        }

        char ch = str2.charAt(0);     
        String restOfStr2 = str2.substring(1);   

        if(map.containsKey(ch)){
            String mappedString = map.get(ch);
            if(str1.length() >= mappedString.length()){
                String left = str1.substring(0, mappedString.length());
                String right = str1.substring(mappedString.length());
                if(left.equals(mappedString)){
                    printWordPatterns(right, restOfStr2, map, originalPattern);
                }
            }
        }else{
            for(int i=0; i<str1.length(); i++){     
                String left = str1.substring(0, i+1);    
                String right = str1.substring(i+1);       
                map.put(ch, left);
                printWordPatterns(right, restOfStr2, map, originalPattern);
                map.remove(ch);
            }
        }
    }
}
