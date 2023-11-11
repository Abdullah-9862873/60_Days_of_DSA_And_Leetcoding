public class Video41_Print_maze_path_with_jumps {
    public static void main(String[] args) {
        printPath(1,1,2,2,"");
    }
    public static void printPath(int rStart, int cStart, int destR, int destC, String ans){
        if(cStart > destC || rStart > destR){
            return;
        }
        if(rStart == destR && cStart == destC){
            System.out.println(ans);
            return;
        }
        

        // rStart can at a time jump to how many steps?? ---> totalRows(destR) - (initialRow) rStart

        // Col Jumps ---> h jumps
        
        for(int i=1; i<=destC-i; i++){
            printPath(rStart, cStart+i, destR, destC, ans + "h" + Integer.toString(i));
        }

        // Row Jumps ---> v jumps
        for(int i=1; i<=destR-i; i++){
            printPath(rStart+i, cStart, destR, destC, ans + "v" + Integer.toString(i));
        }

        // Diagonal Jumps ---> d jumps
        for(int i=1; i<=destR-i && i<=destC-i; i++){
            printPath(rStart+i, cStart+i, destR, destC, ans + "d" + Integer.toString(i));
        }

    }
}
