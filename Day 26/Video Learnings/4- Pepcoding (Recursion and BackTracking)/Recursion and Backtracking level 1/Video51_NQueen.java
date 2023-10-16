import java.util.ArrayList;

public class Video51_NQueen {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        printNQueen(8, 0, 0, ans);
        System.out.println(ans);
    }

    public static void printNQueen(int n, int row, int col, ArrayList<String> result) {
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            if(i > 0){
                arr[0][i-1] = 0;
            }
            arr[0][i] = 1;
            result.add(getAns(arr, 0, 0, ""));
        }
    }

    public static String getAns(int[][] arr, int row, int col, String current) {
        if(row < 0 || row >=arr.length || col < 0 || col >= arr[row].length){
            return "";
        }

        int[][] dummyArr = new int[arr.length][arr[0].length];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                dummyArr[i][j] = arr[i][j];
            }
        }

        for(int i=0; i<dummyArr.length; i++){
            for(int j=0; j<dummyArr[i].length; j++){
                if(dummyArr[i][j] == 1){
                    current = current + Integer.toString(i) + Integer.toString(j) + "-";
                    continue;
                }
                boolean check = queenPresentInPath(dummyArr, i, j);
                if(!check){
                    dummyArr[i][j] = 1;
                    current = current + Integer.toString(i) + Integer.toString(j) + "-";
                }
            }
        }
        current = current.substring(0, current.length()-1);
        return current;
    }

    public static boolean queenPresentInPath(int[][] arr, int row, int col) {
        boolean horizontal = checkHorizontal(arr, row, col);
        boolean vertical = checkVertical(arr, row, col);
        boolean diagonal = checkAllDiagonal(arr, row, col);

        return horizontal || vertical || diagonal;
    }

    public static boolean checkHorizontal(int[][] arr, int rowPlaced, int colPlaced) {
        boolean leftSide = checkLeftRight(arr, rowPlaced, colPlaced, -1);
        boolean rightSide = checkLeftRight(arr, rowPlaced, colPlaced, 1);
        return leftSide || rightSide;
    }

    public static boolean checkLeftRight(int[][] arr, int rowPlaced, int colPlaced, int direction) {
        if (colPlaced < 0 || colPlaced >= arr[rowPlaced].length) {
            return false;
        }

        if (arr[rowPlaced][colPlaced] == 1) {
            return true;
        }

        return checkLeftRight(arr, rowPlaced, colPlaced + direction, direction);
    }

    public static boolean checkVertical(int[][] arr, int rowPlaced, int colPlaced) {
        boolean topSide = checkTopBottom(arr, rowPlaced, colPlaced, -1);
        boolean bottomSide = checkTopBottom(arr, rowPlaced, colPlaced, 1);
        return topSide || bottomSide;
    }

    public static boolean checkTopBottom(int[][] arr, int rowPlaced, int colPlaced, int direction) {
        if (rowPlaced < 0 || rowPlaced >= arr.length) {
            return false;
        }
        if (arr[rowPlaced][colPlaced] == 1) {
            return true;
        }

        return checkTopBottom(arr, rowPlaced + direction, colPlaced, direction);
    }

    public static boolean checkAllDiagonal(int[][] arr, int rowPlaced, int colPlaced) {
        boolean topLeftSide = checkDiagonal(arr, rowPlaced, colPlaced, -1, -1);
        boolean topRightSide = checkDiagonal(arr, rowPlaced, colPlaced, -1, +1);
        boolean bottomLeftSide = checkDiagonal(arr, rowPlaced, colPlaced, +1, -1);
        boolean bottomRightSide = checkDiagonal(arr, rowPlaced, colPlaced, +1, +1);
        return topLeftSide || topRightSide || bottomLeftSide || bottomRightSide;
    }

    public static boolean checkDiagonal(int[][] arr, int rowPlaced, int colPlaced, int rowDirection, int colDirection) {
        if (rowPlaced < 0 || rowPlaced >= arr.length || colPlaced < 0 || colPlaced >= arr[rowPlaced].length) {
            return false;
        }
        if (arr[rowPlaced][colPlaced] == 1) {
            return true;
        }

        return checkDiagonal(arr, rowPlaced + rowDirection, colPlaced + colDirection, rowDirection, colDirection);
    }
}
