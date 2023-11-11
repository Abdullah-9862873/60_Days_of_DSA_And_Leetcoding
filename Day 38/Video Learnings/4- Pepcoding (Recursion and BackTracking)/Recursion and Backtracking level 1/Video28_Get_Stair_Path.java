import java.util.*;
public class Video28_Get_Stair_Path {
    public static void main(String[] args) {
        int stairs = 4;
        System.out.println(getPaths(stairs));
        // I can only take 1 step, 2 steps or 3 steps at a time
    }
    public static ArrayList<String> getPaths(int stairs){
        if(stairs == 0){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }else if(stairs < 0){
            ArrayList<String> arr = new ArrayList<>();
            return arr;
        }

        ArrayList<String> paths1 = getPaths(stairs - 1);
        ArrayList<String> paths2 = getPaths(stairs - 2);
        ArrayList<String> paths3 = getPaths(stairs - 3);
        ArrayList<String> path = new ArrayList<>();

        for(String temp : paths1){
            path.add(1 + temp);
        }
        for(String temp : paths2){
            path.add(2 + temp);
        }
        for(String temp : paths3){
            path.add(3 + temp);
        }
        return path;
    }
}
