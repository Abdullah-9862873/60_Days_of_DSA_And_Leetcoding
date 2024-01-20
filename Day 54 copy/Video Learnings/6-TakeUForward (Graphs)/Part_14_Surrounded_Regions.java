// Using DFS
import java.util.Arrays;

public class Part_14_Surrounded_Regions {
    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'O', 'X', 'X' },
                { 'X', 'O', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X', 'X' },
        };
        surroundRegions(board);
        for (char[] temp : board) {
            System.out.println(Arrays.toString(temp));
        }
    }

    public static void surroundRegions(char[][] board) {
        // visit the boundaries and if you find any O there then mark the respected Os
        // along...
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Traversing first row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                markVisited(board, visited, 0, i);
            } else {
                visited[0][i] = true;
            }
        }

        // Traversing last row
        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length - 1][i] == 'O') {
                markVisited(board, visited, board.length - 1, i);
            } else {
                visited[board.length - 1][i] = true;
            }
        }

        // Traversing first col
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                markVisited(board, visited, i, 0);
            } else {
                visited[i][0] = true;
            }
        }

        // Traversing last col
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') {
                markVisited(board, visited, i, board[0].length - 1);
            } else {
                visited[i][board[0].length - 1] = true;
            }
        }

        // Now you have marked every thing you just have to convert the inner remaining
        // Os
        // to Xs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                    continue;
                } else {
                    if (!visited[i][j] && board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    visited[i][j] = true;
                }
            }
        }
    }

    public static int[] dRow = { -1, 0, 1, 0 };
    public static int[] dCol = { 0, 1, 0, -1 };

    public static void markVisited(char[][] board, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int adjx = row + dRow[i];
            int adjy = col + dCol[i];

            if (isValid(board, visited, adjx, adjy)) {
                markVisited(board, visited, adjx, adjy);
            }
        }

    }

    public static boolean isValid(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= visited.length || col < 0 || col >= visited[row].length || visited[row][col] == true) {
            return false;
        }
        if (visited[row][col] == false && board[row][col] == 'O') {
            return true;
        }
        return false;
    }
}
