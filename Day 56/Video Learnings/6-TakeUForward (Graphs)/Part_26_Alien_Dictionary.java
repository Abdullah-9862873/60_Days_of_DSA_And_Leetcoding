import java.util.*;
public class Part_26_Alien_Dictionary {
    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab","cad"};
        int n = 5;      // Dictionary length
        int k = 4;          // represent the alphabets used like a,b,c,d in this case

        String ans = findOrder(dict,n,k);
        System.out.println(ans);
    }
    public static String findOrder(String[] dict, int n, int k){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        ArrayList<Integer> order = topologicalSort(adj,k);
        String ans = "";
        for(int i=0; i<order.size(); i++){
            ans += (char)(order.get(i) + (int)('a'));
        }
        return ans;
    }   
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegrees = new int[n];
        for(int i=0; i<n; i++){
            ArrayList<Integer> arr = adj.get(i);
            for(int j=0; j<arr.size(); j++){
                inDegrees[arr.get(j)]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<inDegrees.length; i++){
            if(inDegrees[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int top = q.remove();
            ans.add(top);

            ArrayList<Integer> list = adj.get(top);
            for(int i=0; i<list.size(); i++){
                int num = list.get(i);
                inDegrees[num]--;
                if(inDegrees[num] == 0){
                    q.add(num);
                }
            }
        }
        return ans;
    }
}
