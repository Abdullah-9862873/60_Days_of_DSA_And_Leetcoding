import java.util.*;

public class Part_30_WordLadder_2 {
    public static void main(String[] args) {
        String startWord = "bat";
        String endWord = "coz";
        List<String> wordList = new ArrayList<>(Arrays.asList("pat","bot","pot","poz","coz"));

       List<List<String>> ans = getShortestWordLadder(startWord,endWord,wordList);
        for(List<String> list: ans){
            System.out.println(list);
        }
    }
    public static  List<List<String>> getShortestWordLadder(String startWord, String endWord, List<String> wordList){
        List<List<String>> ans = new ArrayList<>();

        Set<String> st = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }
        Queue<ArrayList<String>> q = new ArrayDeque<>();
        q.add(new ArrayList<>(Arrays.asList(startWord)));

        int level = 0;
        ArrayList<String> usedWordsList = new ArrayList<>();
        usedWordsList.add(startWord);
        st.remove(startWord);

        while(!q.isEmpty()){
            ArrayList<String> list = q.remove();

            if(list.size() > level){
                level++;
                for(String it: list){
                    st.remove(it);
                }
            }

            String word = list.get(list.size()-1);

            if(word.equals(endWord)){
                if(ans.size() == 0){
                    ans.add(list);
                }else{
                    if(ans.get(0).size() == list.size()){
                        ans.add(list);
                    }
                }
            }
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] wordToCharArray = word.toCharArray();
                    wordToCharArray[i] = ch;
                    String replacedWord = new String(wordToCharArray);
                    if(st.contains(replacedWord)){
                        list.add(replacedWord);
                        ArrayList<String> newList = new ArrayList<>(list);
                        q.add(newList);
                        usedWordsList.add(replacedWord);
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
