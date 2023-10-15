import java.util.*;
public class FindAPeakElement2{
    public static void main(String[] args) {
        int[][] mat = {
            {}
        };
        int[] ans = new int[2];
        ans = findPeak(mat);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] findPeak(int[][] mat){
        int rStart = 0;
        int rEnd = mat.length-1;
        int cStart = 0;
        int cEnd = mat[0].length-1;

        // Case 1 if only one row but more than one cols
        if(mat.length == 1 && mat[0].length > 1){
            int[] maxElementIndex = new int[2];
            maxElementIndex = findMaxInRow(mat, 0, cStart , cEnd);
            return maxElementIndex;
        }
        //Case 2 if only one col but more than one rows
        if(mat[0].length == 1 && mat.length > 1){
            int[] maxElementIndex = new int[2];
            maxElementIndex = findMaxInCol(mat, cStart, rStart, rEnd);
            return maxElementIndex;
        }
        // Case 3 if only one elemnet exists
        if(mat[0].length == 1 && mat.length == 1){
            return new int[]{0,0};
        }
        // Case 4 if Empty
        if(mat.length == 0){
            return new int[]{-1,-1};
        }

        while(rStart <= rEnd){
            int rMid = rStart + (rEnd - rStart)/2;
            int[] maxElementIndex = new int[2];
            maxElementIndex = findMaxInRow(mat, rMid, cStart, cEnd);
            // Case 1 if max element in rMid is at the rStart
            if(maxElementIndex[0] == rStart && maxElementIndex[0] != rEnd){
                // Observe only down adjacent element
                if(mat[maxElementIndex[0]][maxElementIndex[1]] < mat[maxElementIndex[0]+1][maxElementIndex[1]]){
                    rStart = rMid + 1;
                }else{
                    return maxElementIndex;
                }
            }

            // Case 2 if max element in rMid is at the rEnd
            if(maxElementIndex[0] == rEnd && maxElementIndex[0] != rStart){
                // Observe only up adjacent element
                if(mat[maxElementIndex[0]][maxElementIndex[1]] < mat[maxElementIndex[0]-1][maxElementIndex[1]]){
                    rEnd = rMid-1;
                }else{
                    return maxElementIndex;
                }
            }

            // Case 3 if max element in rMid is neither at rStart not at rEnd
            if(maxElementIndex[0] > rStart && maxElementIndex[0] < rEnd){
                // Observe both up and down
                if(mat[maxElementIndex[0]][maxElementIndex[1]] < mat[maxElementIndex[0]+1][maxElementIndex[1]]){
                    rStart = rMid + 1;
                }
                else if(mat[maxElementIndex[0]][maxElementIndex[1]] < mat[maxElementIndex[0]-1][maxElementIndex[1]]){
                    rEnd = rMid-1;
                }else{
                    return maxElementIndex;
                }
            }
            // Case 4 if rStart rMId and rEnd all are at the same row
            if(maxElementIndex[0] == rStart && maxElementIndex[0] == rMid && maxElementIndex[0] == rEnd){
                // Return the maximum of that row
                return findMaxInRow(mat, rMid, cStart, cEnd);
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] findMaxInRow(int[][] arr, int row, int cStart, int cEnd){
        int[] ans = new int[2];
        int max = -1;
        for(int i=cStart; i<=cEnd; i++){
            if(arr[row][i] > max){
                ans[0] = row;
                ans[1] = i;
                max = arr[row][i];
            }

        }
        return ans;
    }
    public static int[] findMaxInCol(int[][] arr, int col, int rStart, int rEnd){
        int[] ans = new int[2];
        int max = -1;
        for(int i=rStart; i<=rEnd; i++){
            if(arr[i][col] > max){
                ans[0] = i;
                ans[1] = col;
                max = arr[i][col];
            }
        }
        return ans;
    }
}