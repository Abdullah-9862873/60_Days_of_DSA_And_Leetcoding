import java.util.*;

public class Part_51_Number_of_Islands_II {

    public static class DisjointSet {
        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
        int totalRows = 4;
        int totalCols = 5;
        int[][] operators = {
                {0, 0},
                {0, 0},
                {1, 1},
                {1, 0},
                {0, 1},
                {0, 3},
                {1, 3},
                {0, 4},
                {3, 2},
                {2, 2},
                {1, 2},
                {0, 2},
        };
        List<Integer> islands = getNumberOfIslands(totalCols, totalRows, operators);
        System.out.println(islands);
    }

    public static List<Integer> getNumberOfIslands(int m, int n, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        List<Integer> ans = new ArrayList<>();
    
        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
    
            if (visited[row][col]) {
                ans.add(count);
                continue;
            }
            visited[row][col] = true;
            count++;
    
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int j = 0; j < 4; j++) {
                int adjRow = row + dRow[j];
                int adjCol = col + dCol[j];
                if (isValid(adjRow, adjCol, n, m) && visited[adjRow][adjCol]) {
                    int node1 = row * m + col;
                    int node2 = adjRow * m + adjCol;
                    if (ds.findUltimateParent(node1) != ds.findUltimateParent(node2)) {
                        ds.unionByRank(node1, node2);
                        count--;
                    }
                }
            }
            ans.add(count);
        }
    
        return ans;
    }
    
    public static boolean isValid(int adjRow, int adjCol, int n, int m) {
        return adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m;
    }
}
