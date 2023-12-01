import java.util.Stack;

public class Part_06_Depth_First_Search3 {
    public static class Pair {
        int first;
        int second;

        public Pair(int val1, int val2) {
            this.first = val1;
            this.second = val2;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        String dfsTraversal = dfsTraverse(arr, 0, 0, visited);
        System.out.println(dfsTraversal);
    }

    public static int[] dRow = { -1, 0, 1, 0 };
    public static int[] dCol = { 0, 1, 0, -1 };

    public static boolean isValid(int[][] arr, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[x].length || visited[x][y] == true) {
            return false;
        }
        return true;
    }

    public static String dfsTraverse(int[][] arr, int row, int col, boolean[][] visited) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(row, col));

        String str = "";

        while (!st.empty()) {
            Pair curr = st.pop();

            row = curr.first;
            col = curr.second;

            // Checking again because there will be duplicacy in the stack and we want them to be added in the str only once
            if(!isValid(arr, visited, row, col)){
                continue;
            }
            visited[row][col] = true;
            str = str + "-" + arr[row][col];

            // Push all the adjacent cells
            for (int i = 0; i < 4; i++) {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];
                if(isValid(arr, visited, adjx, adjy)){
                    st.push(new Pair(adjx, adjy));
                }
            }
        }
        return str.substring(1);
    }
}
