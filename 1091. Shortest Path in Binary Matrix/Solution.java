class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] moves = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 } };
        int n = grid.length, count = 0;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int l = q.size();
            count++;
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) return count;
                for (int[] m : moves) {
                    int nx = curr[0] + m[0], ny = curr[1] + m[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (grid[nx][ny] == 1) continue;
                    grid[nx][ny] = 1;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
        return -1;
    }
}
