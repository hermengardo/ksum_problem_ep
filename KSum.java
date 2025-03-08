import java.util.Arrays;

public class KSum {
    public static int COUNTER = 0;
    public static void main(String[] args) {
        int [] X = StdIn.readAllInts();
        int k = Integer.parseInt(args[0]);
        Stopwatch timer = new Stopwatch();
        Arrays.sort(X);
        findKsum(X, k);
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }

    public static void findKsum(int [] X, int k) {
        findKsum(X, 0, k, 0, 0);
        System.out.println(COUNTER);
    }

    public static void findKsum(int [] X, int pointer, int k, int sum, int added) {
        if (pointer == X.length) {
            if (sum == 0 && added == k) COUNTER += 1;
            return;
        }

        int value = X[pointer];

        findKsum(X, pointer + 1, k, sum + value, added + 1);
        findKsum(X, pointer + 1, k, sum, added);
    }
}
