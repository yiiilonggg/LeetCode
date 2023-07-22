class Solution {
    int[][] moves = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k + 1];
        return r(n, k, row, column);
    }
    public double r(int n, int k, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0;
        if (k == 0) return 1;
        if (dp[row][col][k] != 0) return dp[row][col][k];
        double res = 0;
        for (int[] m : moves) {
            res += 0.125 * r(n, k - 1, row + m[0], col + m[1]);
        }
        dp[row][col][k] = res;
        return res;
    }
}
