class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Long, Integer> d = new HashMap<>();
        long[] res = new long[5];
        for (int[] c : coordinates) {
            int x = c[0], y = c[1];
            for (int i = -1; i <= 0; i++) {
                for (int j = -1; j <= 0; j++) {
                    int nx = x + i, ny = y + j;
                    long idx = nx * n + ny;
                    if (nx < 0 || ny < 0 || nx >= m - 1 || ny >= n - 1) continue;
                    d.put(idx, d.getOrDefault(idx, 0) + 1);
                }
            }
        }
        for (int c : d.values()) res[c]++;
        res[0] = 1L * (m - 1) * (n - 1) - (res[1] + res[2] + res[3] + res[4]);
        return res;
    }
}
