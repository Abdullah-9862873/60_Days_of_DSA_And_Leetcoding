import java.util.Arrays;

public class Video_09_CrossWord_Puzzle {
    public static void main(String[] args) {
        char[][] arr = {
                { '+', '_', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '_', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '_', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '_', '_', '_', '_', '_', '+', '+', '+', '+' },
                { '+', '_', '+', '+', '+', '_', '+', '+', '+', '+' },
                { '+', '_', '+', '+', '+', '_', '+', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '_', '+', '+', '+', '+' },
                { '+', '+', '_', '_', '_', '_', '_', '_', '+', '+' },
                { '+', '+', '+', '+', '+', '_', '+', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '_', '+', '+', '+', '+' },
        };
        String[] words = { "delhi", "ankara", "london", "iceland" };

        solve(arr, words, 0);
    }

    public static void solve(char[][] arr, String[] words, int index) {
        if (index == words.length) {
            print(arr);
            return;
        }
        String word = words[index];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (canPlaceHorizontally(arr, word, i, j)) {
                    boolean[] wePlaced = placeWordHorizontally(arr, word, i, j);
                    solve(arr, words, index + 1);
                    unPlaceWordHorizontally(arr, wePlaced, i, j);
                }
                if (canPlaceVertically(arr, word, i, j)) {
                    boolean[] wePlaced = placeWordVertically(arr, word, i, j);
                    solve(arr, words, index + 1);
                    unPlaceWordVertically(arr, wePlaced, i, j);
                }
            }
        }
    }

    public static boolean canPlaceHorizontally(char[][] arr, String word, int row, int col) {
        if (col - 1 >= 0 && arr[row][col - 1] != '+') {
            return false;
        } else if (col + word.length() < arr[0].length && arr[row][col + word.length()] != '+') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (col + i >= arr[0].length) {
                return false;
            }

            if (arr[row][col + i] == '_' || arr[row][col + i] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canPlaceVertically(char[][] arr, String word, int row, int col) {
        if (row - 1 >= 0 && arr[row - 1][col] != '+') {
            return false;
        } else if (row + word.length() < arr.length && arr[row + word.length()][col] != '+') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (row + i >= arr.length) {
                return false;
            }

            if (arr[row + i][col] == '_' || arr[row + i][col] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean[] placeWordHorizontally(char[][] arr, String word, int row, int col) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (arr[row][col + i] == '_') {
                wePlaced[i] = true;
                arr[row][col + i] = word.charAt(i);
            }
        }
        return wePlaced;
    }

    public static void unPlaceWordHorizontally(char[][] arr, boolean[] wePlaced, int row, int col) {
        for (int i = 0; i < wePlaced.length; i++) {
            if (wePlaced[i]) {
                arr[row][col + i] = '_';
            }
        }
    }

    public static boolean[] placeWordVertically(char[][] arr, String word, int row, int col) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (arr[row + i][col] == '_') {
                wePlaced[i] = true;
                arr[row + i][col] = word.charAt(i);
            }
        }
        return wePlaced;
    }

    public static void unPlaceWordVertically(char[][] arr, boolean[] wePlaced, int row, int col) {
        for (int i = 0; i < wePlaced.length; i++) {
            if (wePlaced[i]) {
                arr[row + i][col] = '_';
            }
        }
    }

    public static void print(char[][] arr) {
        for (char[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
