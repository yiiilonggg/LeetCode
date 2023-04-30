class Solution {
    int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    
    public int findMaxFish(int[][] grid) {
        int r = grid.length, c = grid[0].length, high = 0;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                int curr = 0;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] { i, j });
                while (!q.isEmpty()) {
                    int[] coord = q.poll();
                    curr += grid[coord[0]][coord[1]];
                    for (int[] m : moves) {
                        int nx = coord[0] + m[0], ny = coord[1] + m[1];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                        if (visited[nx][ny] || grid[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        q.offer(new int[] { nx, ny });
                    }
                }
                high = Math.max(high, curr);
            }
        }
        return high;
    }
}