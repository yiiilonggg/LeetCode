class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0, n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][i] + mat[i][n - i - 1];
        }
        return (n % 2 == 0) ? res : res - mat[n / 2][n / 2];
    }
}