public class Video38_Print_Maze_Paths {
    public static void main(String[] args) {
        printPath(1, 1, 9, 9, "");
    }

    public static void printPath(int rStart, int cStart, int destR, int destC, String ans) {
        if(rStart > destR || cStart > destC){
            return;
        }
        if(rStart == destR && cStart == destC){
            System.out.println(ans);
            return;
        }
        printPath(rStart + 1, cStart, destR, destC, ans + "v");
        printPath(rStart, cStart + 1, destR, destC, ans + "h");
    }
}
