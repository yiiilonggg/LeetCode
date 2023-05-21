class Solution {
    int r, c;
    Queue<int[]> q = new LinkedList<>();
    int[][] g;
    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public int shortestBridge(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        g = grid;
        visited = new boolean[r][c];
        int count = 0;
        for (int i = 0; i < r && q.isEmpty(); i++) {
            for (int j = 0; j < c && q.isEmpty(); j++) {
                if (grid[i][j] == 0) continue;
                find(i, j);
            }
        }
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] curr = q.poll();
                for (int[] m : moves) {
                    int nx = curr[0] + m[0], ny = curr[1] + m[1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if (visited[nx][ny]) continue;
                    if (grid[nx][ny] == 1) return count;
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
            count++;
        }
        return -1;
    }

    public void find(int x, int y) {
        if (x < 0 || y < 0 || x >= r || y >= c) return;
        if (visited[x][y] || g[x][y] == 0) return;
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        for (int[] m : moves) {
            find(x + m[0], y + m[1]);
        }
    }
}
