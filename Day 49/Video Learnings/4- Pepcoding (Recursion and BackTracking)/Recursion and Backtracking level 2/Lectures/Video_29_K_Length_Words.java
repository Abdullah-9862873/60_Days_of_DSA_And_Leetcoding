import java.util.*;
public class Video_29_K_Length_Words{
    public static void main(String[] args) {
        String str = "abcabc";
        int k = 2;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        String uniqueElements = "";
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            uniqueElements += iterator.next();
        }
        char[] boxes = new char[k];
        printKLengthWords(uniqueElements,0, k, boxes, 0);
    }
    public static void printKLengthWords(String uniqueElements,int level, int k, char[] boxes, int ssf){
        if(level >= uniqueElements.length()){
            if(ssf == boxes.length){
                System.out.println(Arrays.toString(boxes));
            }
            return;
        }
        for(int i=0; i<k; i++){
            if(boxes[i] == '\0'){
                boxes[i] = uniqueElements.charAt(level);
                printKLengthWords(uniqueElements, level+1, k, boxes, ssf+1);
                boxes[i] = '\0';
            }
        }

        printKLengthWords(uniqueElements,level+1, k, boxes, ssf);
    }
}