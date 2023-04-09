class Solution {
    public int minimumVisitedCells(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length, steps = 1;
        if (n == 1 && m == 1) return 1;
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int l = q.size();
            for (int j = 0; j < l; j++) {
                int[] curr = q.poll();
                for (int i = 1; i <= grid[curr[0]][curr[1]]; i++) {
                    int nx = curr[0] + i, ny = curr[1] + i;
                    if ((nx == n - 1 && curr[1] == m - 1) || curr[0] == n - 1 && ny == m - 1) return steps + 1;
                    if (nx < n && !visited[nx][curr[1]] && grid[nx][curr[1]] > 0) {
                        visited[nx][curr[1]] = true;
                        q.offer(new int[] { nx, curr[1] });
                    }
                    if (ny < m && !visited[curr[0]][ny] && grid[curr[0]][ny] > 0) {
                        visited[curr[0]][ny] = true;
                        q.offer(new int[] { curr[0], ny });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}