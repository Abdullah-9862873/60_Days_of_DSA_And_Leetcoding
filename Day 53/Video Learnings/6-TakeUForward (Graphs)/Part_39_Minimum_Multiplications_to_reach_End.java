import java.util.*;

public class Part_39_Minimum_Multiplications_to_reach_End {
    public static class Pair {
        int steps;
        int num;

        public Pair(int val1, int val2) {
            this.steps = val1;
            this.num = val2;
        }
    }

    public static void main(String[] args) {
        int start = 3;
        int end = 75;
        int[] arr = { 2, 5, 7 };
        int mod = 100000;

        int ans = getMinMultiplicationsToReachEnd(start, end, arr, mod);
        System.out.println(ans);
    }

    public static int getMinMultiplicationsToReachEnd(int start, int end, int[] arr, int mod) {
        Queue<Pair> q = new ArrayDeque<>();
        int[] distance = new int[mod];
        distance[start] = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);

        q.add(new Pair(0, start));
        while (!q.isEmpty()) {
            Pair top = q.remove();
            int steps = top.steps;
            int num = top.num;

            for (int i = 0; i < arr.length; i++) {
                int mul = (num * arr[i]) % mod;
                if (steps + 1 < distance[mul]) {
                    distance[mul] = steps + 1;
                    if (mul == end) {
                        return steps+1;
                    }
                    q.add(new Pair(steps + 1, mul));
                }
            }
        }
        return -1;
    }
}
