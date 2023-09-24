import java.util.Arrays;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] aliceSizes = { 2, 2, 5 };
        int[] bobSizes = { 3, 4 };

        int aliceTotal = sum(aliceSizes);
        int bobTotal = sum(bobSizes);
        int[] ans = new int[2];

        for (int i = 0; i < aliceSizes.length; i++) {
                for(int j=0; j<bobSizes.length; j++){
                    if (aliceTotal - aliceSizes[i] + bobSizes[j] == bobTotal - bobSizes[j] + aliceSizes[i]) {
                        ans = new int[] { aliceSizes[i], bobSizes[j] };
                    }
                }
            }
        System.out.println(Arrays.toString(ans));
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (Integer i : arr) {
            sum += i;
        }
        return sum;
    }
}
