import java.util.Arrays;

public class KSum {
    public static int COUNTER = 0;
    public static void main(String[] args) {
        int [] X = StdIn.readAllInts();
        int k = Integer.parseInt(args[0]);

        Arrays.sort(X);

        Stopwatch timer = new Stopwatch();
        findKsum(X, k);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        System.out.println(COUNTER);
    }

    public static void findKsum(int [] X, int k) {
        findKsum(X, k, 0, 0, 0, 0);

    }

    public static void findKsum(int [] X, int k, int lowerPointer, int curr, int target, int size) {
        if (size == k && target == 0) {
            COUNTER++;
            return;
        }

        if (lowerPointer == X.length || size >= k || target < 0) return;

        int newCurr = X[lowerPointer];
        int newTarget = target - newCurr;

        findKsum(X, k, lowerPointer + 1, newCurr, newTarget, size + 1);
        findKsum(X, k, lowerPointer + 1, curr, target, size);
    }
}
