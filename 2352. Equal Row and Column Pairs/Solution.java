class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, res = 0;
        int[][] colwise = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colwise[i][j] = grid[j][i];
            }
        }
        for (int[] row : grid) {
            for (int[] col : colwise) {
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if (row[i] != col[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) res++;
            }
        }
        return res;
    }
}
