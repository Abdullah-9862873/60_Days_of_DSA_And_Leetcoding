import java.util.Deque;
import java.util.LinkedList;

public class MaxValueOfEquation {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Point> deque = new LinkedList<>();
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            int xi = points[i][0];
            int yi = points[i][1];

            while (!deque.isEmpty() && xi - deque.peekFirst().x > k) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                int xj = deque.peekFirst().x;
                int yj = deque.peekFirst().y;
                int value = yi + yj + (xi - xj);
                maxValue = Math.max(maxValue, value);
            }

            while (!deque.isEmpty() && yi - xi >= deque.peekLast().y - deque.peekLast().x) {
                deque.pollLast();
            }

            deque.offerLast(new Point(xi, yi));
        }

        return maxValue;
    }
}
