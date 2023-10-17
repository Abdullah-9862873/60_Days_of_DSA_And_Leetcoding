public class Video10_Friends_Pairing {
    public static void main(String[] args) {
        int n = 3;
        boolean[] trackLevel = new boolean[n + 1];
        solve(1, n, trackLevel, "");
    }

    public static void solve(int i, int n, boolean[] used, String asf) {
        if (i > n) {
            System.out.println(asf);
            return;
        }

        if (used[i]) {
            solve(i + 1, n, used, asf);
        } else {
            used[i] = true;
            solve(i + 1, n, used, asf + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                if (used[j] == false) {
                    used[j] = true;
                    solve(i + 1, n, used, asf + "(" + i + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }
}
