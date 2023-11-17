public class Video_02_NQueen_Using_Branch_and_Bound_Algorithm {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        boolean[] colArray = new boolean[arr.length];
        boolean[] normalDiagonal = new boolean[2*arr.length - 1];
        boolean[] reverseDiagonal = new boolean[2*arr.length - 1];

        printNQueens(arr, 0, colArray, normalDiagonal, reverseDiagonal, "");
    }
    public static void printNQueens(int[][] arr, int row, boolean[] colArray, boolean[] normalDiagonal, boolean[] reverseDiagonal, String asf){
        if(row == arr.length){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<arr[row].length; i++){
            if(colArray[i] == false && normalDiagonal[row+i] == false && reverseDiagonal[row-i+arr.length-1] == false){
                arr[row][i] = 1;
                colArray[i] = true;
                normalDiagonal[row+i] = true;
                reverseDiagonal[row-i+arr.length-1] = true;
                printNQueens(arr, row+1, colArray, normalDiagonal, reverseDiagonal, asf + Integer.toString(row) + "-" + Integer.toString(i) + ",");
                arr[row][i] = 0;
                colArray[i] = false;
                normalDiagonal[row+i] = false;
                reverseDiagonal[row-i+arr.length-1] = false;
            }
        }
    }
    public boolean isSafe(int[][] arr, int row, int col, boolean[] colArray, boolean[] normalDiagonal, boolean[] reverseDiagonal){
        if(colArray[col] || normalDiagonal[row+col] || reverseDiagonal[row-col+arr.length-1]){
            return false;
        }
        return true;
    }
}
