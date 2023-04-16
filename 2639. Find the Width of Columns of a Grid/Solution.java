class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int high = 1;
            for (int j = 0; j < m; j++) {
                high = Math.max(high, Integer.toString(grid[j][i]).length());
            }
            res[i] = high;
        }
        return res;
    }
}