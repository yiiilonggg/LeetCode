class Solution {
    public int maxDistance(int[][] grid) {
        int[][] move = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int n = grid.length, dist = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) q.offer(new int[] { i, j });
            }
        }
        if (q.size() == 0 || q.size() == n * n) return -1;
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                for (int[] m : move) {
                    if (curr[0] + m[0] < 0 || curr[0] + m[0] >= n || curr[1] + m[1] < 0 || curr[1] + m[1] >= n) continue;
                    if (grid[curr[0] + m[0]][curr[1] + m[1]] == 1) continue;
                    grid[curr[0] + m[0]][curr[1] + m[1]] = 1;
                    q.offer(new int[] { curr[0] + m[0], curr[1] + m[1] });
                }
            }
            dist++;
        }
        return dist - 1;
    }
}