import java.util.*;
public class Video_30_Get_Maze_Paths{
    public static void main(String[] args) {
        System.out.println(findPaths(1,1,3,3));
    }
    public static ArrayList<String> findPaths(int src1, int src2, int dst1, int dst2){
        if(src1 == dst1 && src2 == dst2){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> paths1 = new ArrayList<>();
        ArrayList<String> paths2 = new ArrayList<>();

        if(src1 < dst1){
            paths1 = findPaths(src1+1, src2, dst1, dst2);
        }
        if(src2 < dst2){
            paths2 = findPaths(src1, src2+1, dst1, dst2);
        }
        for(String vpath: paths1){
            ans.add("v" + vpath);
        }

        for(String hpath: paths2){
            ans.add("h" + hpath);
        }
        return ans;
    }
}