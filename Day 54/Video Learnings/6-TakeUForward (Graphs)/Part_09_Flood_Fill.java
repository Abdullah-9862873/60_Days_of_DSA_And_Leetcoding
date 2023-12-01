import java.util.*;

public class Part_09_Flood_Fill {
    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 },
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        floodFill(image, sr, sc, color);
        for (int[] temp : image) {
            System.out.println(Arrays.toString(temp));
        }
    }

    public static void floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        floodFillHelper(image, sr, sc, color, initialColor);
    }

    public static void floodFillHelper(int[][] image, int sr, int sc, int color, int initialColor) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[sr].length || image[sr][sc] != initialColor || image[sr][sr] == color){
            return;
        }
        image[sr][sc] = color;

        floodFillHelper(image, sr-1, sc, color,initialColor);
        floodFillHelper(image, sr+1, sc, color,initialColor);
        floodFillHelper(image, sr, sc-1, color,initialColor);
        floodFillHelper(image, sr, sc+1, color,initialColor);
    }
}
