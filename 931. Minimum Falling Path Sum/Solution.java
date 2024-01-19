class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, res = 10000;
        if (n == 1) return matrix[0][0];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (j == 0) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    } else if (j == n - 1) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[n - 1][i], res);
        }
        return res;
    }
}
