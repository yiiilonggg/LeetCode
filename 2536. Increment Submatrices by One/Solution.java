class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] m = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            m[r1][c1]++;
            if (r2 < n - 1) m[r2 + 1][c1]--;
            if (c2 < n - 1) m[r1][c2 + 1]--;
            if (r2 < n - 1 && c2 < n - 1) m[r2 + 1][c2 + 1]++;
        }
        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                m[r][c] += m[r][c - 1];
            }
        }
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                m[r][c] += m[r - 1][c];
            }
        }
        return m;
    }
}