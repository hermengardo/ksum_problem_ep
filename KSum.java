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
    }

    public static void findKsum(int [] X, int k) {
        findKsum(X, k, 0, 0, 0, 0);
        System.out.println(COUNTER);
    }

    public static void findKsum(int [] X, int k, int lowerPointer, int curr, int target, int size) {
        if (size == k && target == 0) {
            COUNTER++;
            return;
        }

        if (lowerPointer == X.length || size >= k || target < 0) return;

        int upperBound = searchMax((k - size) * target, X, lowerPointer, X.length - 1);
        if (X[upperBound] > (k - size) * target) return;

        int newCurr = X[lowerPointer];
        int newTarget = target - newCurr;

        findKsum(X, k, lowerPointer + 1, newCurr, newTarget, size + 1);
        findKsum(X, k, lowerPointer + 1, curr, target, size);
    }

    /// Lembrar de referenciar
    public static int searchMax(int key, int[] a, int lo, int hi) {
        if (hi <= lo) {
            return lo;
        }
        int mid = lo + (hi - lo + 1) / 2;
        int cmp = a[mid] - key;
        if (cmp > 0)  // key < a[mid]
            return searchMax(key, a, lo, mid - 1);
        else          // key >= a[mid]
            return searchMax(key, a, mid, hi);
    }
}
