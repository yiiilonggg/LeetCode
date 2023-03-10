// credit to: tojuna

class Solution {
    public int[][] directions = { { 0, 1 }, { 0, -1, }, { 1, 0 }, { -1, 0 } };
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { grid[0][0], 0, 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == n - 1 && curr[2] == m - 1) return curr[0];
            if (visited[curr[1]][curr[2]]) continue;
            visited[curr[1]][curr[2]] = true;
            for (int[] d : directions) {
                int nr = d[0] + curr[1], nc = d[1] + curr[2];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                int wait = ((grid[nr][nc] - curr[0]) % 2 == 0) ? 1 : 0;
                pq.offer(new int[] { Math.max(curr[0] + 1, grid[nr][nc] + wait), nr, nc});
            }
        }
        return -1;
    }
}