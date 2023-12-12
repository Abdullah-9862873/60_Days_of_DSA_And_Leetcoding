import java.util.HashSet;

public class Part_52_Making_A_Large_Island {
    // 0-based indexing
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
        int[][] islands = {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 1, 1, 1 },
        };
        int totalRows = 6;
        int totalCols = 5;
        int largestIsland = getLargestIsland(totalRows, totalCols, islands);
        System.out.println(largestIsland);
    }

    public static int getLargestIsland(int n, int m, int[][] islands) {
        DisjointSet ds = new DisjointSet(n * m);

        // Making disjoint sets
        int[] dRow = { -1, 0, 1, 0 };
        int[] dCol = { 0, 1, 0, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (islands[i][j] == 1) {

                    for (int k = 0; k < 4; k++) {
                        int adjRow = i + dRow[k];
                        int adjCol = j + dCol[k];

                        if (isValid(adjRow, adjCol, n, m) && islands[adjRow][adjCol] == 1) {
                            int node1 = i * m + j;
                            int node2 = adjRow * m + adjCol;
                            ds.unionBySize(node1, node2);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (islands[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int adjRow = i + dRow[k];
                        int adjCol = j + dCol[k];

                        if (isValid(adjRow, adjCol, n, m) && islands[adjRow][adjCol] == 1) {
                            int node = adjRow * m + adjCol;
                            int parent = ds.findUltimateParent(node);
                            set.add(parent);
                        }
                    }
                    int sizeTotal = 0;
                    for (Integer val : set) {
                        sizeTotal += ds.size[val];
                    }
                    sizeTotal += 1;
                    max = Math.max(max, sizeTotal);
                }
            }
        }

        // For safety reasons just update the max in total
        for (int val = 0; val < n * m; val++) {
            max = Math.max(max, ds.size[ds.findUltimateParent(val)]);
        }
        return max;
    }

    public static boolean isValid(int adjRow, int adjCol, int n, int m) {
        return adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m;
    }
}
