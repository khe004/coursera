import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private double[] results;
    private int trials;
    private int n;

    // perform T independent experiments on N*N grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new java.lang.IllegalArgumentException();

        this.n = n;
        this.trials = trials;
        results = new double[trials];
        Percolation perc;
        for (int k = 0; k < trials; ++k) {
            perc = new Percolation(n);
            int i = 0;
            int j = 0;
            int openNum = 0;
            while (!perc.percolates()) {
                i = StdRandom.uniform(1, n+1);
                j = StdRandom.uniform(1, n+1);
                if (perc.isOpen(i,j))
                    continue;
                perc.open(i, j);
                openNum++;
            }
            results[k] = openNum / (double)(n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(trials);
    }

    // test client
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.printf("mean = %f%n", ps.mean());
        StdOut.printf("stddev = %f%n", ps.stddev());
        StdOut.printf("95%% confidence interval = %f, %f%n", ps.confidenceLo(), ps.confidenceHi());
    }
}
