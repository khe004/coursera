import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF uf;
    private int n;
    private int openNum;

    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException();

        grid = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = false;
            }
        }
        this.n = n;
        this.openNum = 0;
        int sz = n * n + 2; // two virtual nodes on top and bot
        uf = new WeightedQuickUnionUF(sz);
        for (int i = 0; i <= n; ++i) {
            uf.union(0, i);
            uf.union(sz - 1, n * n + 1 - i);
        }
    }

    public    void open(int i, int j)    // open site (row, col) if it is not open already
    {
        validArgs(i,j);
        if (grid[i-1][j-1])
            return;
        grid[i-1][j-1] = true;
        openNum += 1;
        int idx = posToIndex(i, j);
        if (i > 1 && isOpen(i-1, j))
            uf.union(posToIndex(i-1, j), idx);
        if (i < n && isOpen(i+1, j))
            uf.union(posToIndex(i+1, j), idx);
        if (j > 1 && isOpen(i, j-1))
            uf.union(posToIndex(i, j-1), idx);
        if (j < n && isOpen(i, j+1))
            uf.union(posToIndex(i, j+1), idx);

    }

    public boolean isOpen(int i, int j)  // is site (row, col) open?
    {
        validArgs(i, j);
        return grid[i-1][j-1];
    }

    public boolean isFull(int i, int j)  // is site (row, col) full?
    {
        validArgs(i, j);
        return isOpen(i, j) && uf.connected(posToIndex(i, j), 0);
    }

    public     int numberOfOpenSites()       // number of open sites
    {
        return openNum;
    }

    public boolean percolates()              // does the system percolate?
    {
        return uf.connected(0, n*n+1);
    }

    public static void main(String[] args)   // test client (optional)
    {

    }

    private int posToIndex(int i, int j)
    {
        return (i - 1) * n + j;
    }

    private void validArgs(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n)
            throw new java.lang.IndexOutOfBoundsException();
    }
}

