import java.util.*;

public class Video32_Get_Maze_Paths_with_Jumps {
    public static void main(String[] args) {
        System.out.println(findPaths(1, 1, 3, 3));

        /*
        If I have 3x3 grid then I can move from (1,1) to (1,2) by taking h1 jumps or (1,3) by taking h2 jumps
        Similarly I can go from (1,1) to (2,1) by taking v1 jumps or (3,1) by taking v2 jumps
        Similarly I can go from (1,1) to (2,2) by taking d1 jumps or (3,3) by taking d2 jumps
         */
    }

    public static ArrayList<String> findPaths(int row, int col, int destR, int destC) {
        if (row == destR && col == destC) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        ArrayList<String> path1 = new ArrayList<>(); // Row
        ArrayList<String> path2 = new ArrayList<>(); // Col
        ArrayList<String> path3 = new ArrayList<>(); // Diagonal

        ArrayList<String> paths = new ArrayList<>(); // All paths

        // For Vertical movement (Row movement)
        if (row < destR) {
            for (int i = 1; i <= destR-i; i++) {
                path1 = findPaths(row + i, col, destR, destC);
                for (String path : path1) {
                    paths.add("v" + Integer.toString(i) + path);
                }

            }
        }

        // For Horizontal movement (Col movement)
        if (col < destC) {
            for (int i = 1; i <= destC-i; i++) {
                path2 = findPaths(row, col + i, destR, destC);
                for (String path : path2) {
                    paths.add("h" + Integer.toString(i) + path);
                }
                
            }
        }

        // For Diagonal movement
        if (row < destR && col < destC) {
            for (int i = 1; i <= destR-i && i <= destC-i; i++) {
                path3 = findPaths(row + i, col + i, destR, destC);
                for (String path : path3) {
                    paths.add("d" + Integer.toString(i) + path);
                }

            }
        }

        return paths;
    }
}
