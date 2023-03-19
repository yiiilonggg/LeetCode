class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int[][] movements = new int[][] { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        int depth = 0, n = grid.length;
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                if (grid[curr[0]][curr[1]] != depth) continue;
                if (depth == n * n - 1) return true;
                for (int[] m : movements) {
                    int nx = curr[0] + m[0], ny = curr[1] + m[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    q.offer(new int[] { nx, ny });
                }
            }
            depth++;
        }
        return false;
    }
}