/*
 * $ java-introcs Generator 3 6 314314
 * -2
 * -1
 * 1
 * 1
 * -3
 * -2
 * $  
 */

public class Generator
{
    // Generate N integers in [-M, M)
    public static void main(String[] args)
    {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        long seed = Long.parseLong(args[2]);
        StdRandom.setSeed(seed);
        for (int i = 0; i < N; i++)
            StdOut.println(StdRandom.uniformInt(-M, M));
    }
}
