class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length, low = m * n;
        Map<Integer, Integer> time = new HashMap<>();
        int[] cols = new int[n];
        for (int i = 0; i < m * n; i++) time.put(arr[i], i);
        for (int i = 0; i < m; i++) {
            int rows = 0;
            for (int j = 0; j < n; j++) {
                rows = Math.max(rows, time.get(mat[i][j]));
                cols[j] = Math.max(cols[j], time.get(mat[i][j]));
            }
            low = Math.min(low, rows);
        }
        for (int c : cols) low = Math.min(low, c);
        return low;
    }
}