public class Video36_Print_Stairpath {
    public static void main(String[] args) {
        printstairPaths(3, "");
        // I can only take 1 step, 2 steps or 3 steps at a time
    }
    public static void printstairPaths(int num, String ans){
        if(num == 0){
            System.out.println(ans);
            return;
        }

        int rof = num-1;
        int ros = num-2;
        int rot = num-3;

        if(rof >= 0){
            printstairPaths(rof, ans + 1);
        }
        if(ros >= 0){
            printstairPaths(ros, ans + 2);
        }
        if(rot >= 0){
            printstairPaths(rot, ans+3);
        }

    }
}
