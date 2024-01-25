/*
Anything related to Mergence or Union or Connecting gives us the idea of Disjoint Set

*/

import java.util.*;

public class Part_50_Accounts_Merge {
    // 0-based indexing
    public static class DisjointSet {
        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < size.length; i++) {
                size[i] = 1;
            }

        }

        int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionByRank(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }

        void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> ans = mergeAccounts(accounts);
        for(List<String> it: ans){
            System.out.println(it);
        }
    }
    public static List<List<String>> mergeAccounts(List<List<String>> accounts){
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (map.containsKey(mail)) {
                    ds.unionBySize(map.get(mail), i);
                } else {
                    map.put(mail, i);
                }
            }
        }

        ArrayList<String>[] mergedList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedList[i] = new ArrayList<>(); // Initialize each element before adding elements to it
            for (Map.Entry<String, Integer> it : map.entrySet()) {
                String mail = it.getKey();
                int node = ds.findUltimateParent(it.getValue());
                if (node == i) {
                    mergedList[i].add(mail);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergedList[i].size() == 0){
                continue;
            }
            Collections.sort(mergedList[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: mergedList[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}

/*
 * johnsmith@mail.com -- 0
 * john_newyork@mail.com --- 0
 * 
 */
