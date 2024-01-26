import java.util.*;
public class Part_29_Word_Ladder_1 {
    public static class Pair{
        String word;
        int count;

        public Pair(String word, int num){
            this.word = word;
            this.count = num;
        }
    }
    public static void main(String[] args) {
        String startWord = "hit";
        String endWord = "cog";
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot","dog","lot","log","cog"));

        int ans = getShortestWordLadderLength(startWord,endWord,wordList);
        System.out.println(ans);
    }
    public static int getShortestWordLadderLength(String startWord, String targetWord, List<String> wordList){
        Set<String> st = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(startWord,1));

        st.remove(startWord);
        while(!q.isEmpty()){
            Pair top = q.remove();

            String word = top.word;
            int count = top.count; 
            if(word.equals(targetWord)){
                return count;
            }
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] wordToCharArray = word.toCharArray();
                    wordToCharArray[i] = ch;
                    String replacedWord = new String(wordToCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, count+1));
                    }
                }
            }
        }
        return 0;
    }
}
