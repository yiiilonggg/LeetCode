class Solution {
    public int maxMoves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length, c = grid[0].length, high = 0;
        for (int i = 0; i < r; i++) q.offer(new int[] { i, 0 });
        while (!q.isEmpty() && q.peek()[1] < c - 1) {
            boolean[] col = new boolean[r];
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                for (int j = -1; j < 2; j++) {
                    if (curr[0] + j < 0 || curr[0] + j >= r) continue;
                    if (grid[curr[0]][curr[1]] >= grid[curr[0] + j][curr[1] + 1]) continue;
                    if (col[curr[0] + j]) continue;
                    q.offer(new int[] { curr[0] + j, curr[1] + 1});
                    col[curr[0] + j] = true;
                }
            }
            if (!q.isEmpty()) high++;
        }
        return high;
    }
}