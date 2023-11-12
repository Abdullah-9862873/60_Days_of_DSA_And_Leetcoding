import java.util.*;
public class Video3_Max_Score_of_words {
    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        int[] freqArray = {1,1,1,3,0,0,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        ArrayList<Integer> allScores = new ArrayList<>();

        printSubsets(words, "", 0, freqArray, score, allScores);
        int ans = maxOfAllScores(allScores);
        System.out.println(ans);

    }
    public static void printSubsets(String[] words, String ans, int index, int[] freqArray, int[] score, ArrayList<Integer> allScores){
        if(index == words.length){
            if(isSubsetAllowed(ans, freqArray) && ans.length()!= 0){
                int myScore = calculateScore(ans, score);
                allScores.add(myScore);
            }
            return;
        }

        printSubsets(words, ans+words[index], index+1, freqArray.clone(), score, allScores);
        printSubsets(words, ans, index+1, freqArray.clone(), score, allScores);
    }
    public static boolean isSubsetAllowed(String word, int[] freqArray){
        if(word.length() == 0){
            return true;
        }
        char ch = word.charAt(0);      
        int index = ch - 97;                 
        int freq = freqArray[index];         
        if(freq > 0){
            freqArray[index] = freq - 1;
            return isSubsetAllowed(word.substring(1), freqArray);
        }
        return false;
        
    }
    public static int calculateScore(String word, int[] score){
        if(word.length() == 0){
            return 0;
        }

        int initialScore = 0;

        char ch = word.charAt(0);
        int indexOfChar = ch - 97;
        int val = score[indexOfChar];
        initialScore += val;

        initialScore += calculateScore(word.substring(1), score);

        return initialScore;

    }
    public static int maxOfAllScores(ArrayList<Integer> scores){
        if(scores.size() == 0){
            return Integer.MIN_VALUE;
        }
        int first = scores.get(0);
        scores.remove(0);
        return Math.max(first, maxOfAllScores(scores));
    }
}


