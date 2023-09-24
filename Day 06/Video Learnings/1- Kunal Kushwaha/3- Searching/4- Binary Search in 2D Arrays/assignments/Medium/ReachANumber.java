public class ReachANumber {
    public static void main(String[] args) {
        int target = 5;
        target = Math.abs(target);  

        int step = 0;
        int value = 0;

        while (value < target || (value - target) % 2 != 0) {
            step++;
            value += step;
        }

        System.out.println(step);
    }
}
