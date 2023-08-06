class Solution {
    int n;
    int[][] safe;
    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        int dist = 1;
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;
        safe = new int[n][n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) d.offerLast(new int[] { i, j });
            }
        }
        while (!d.isEmpty()) {
            int l = d.size();
            for (int i = 0; i < l; i++) {
                int[] curr = d.pollFirst();
                for (int[] m : moves) {
                    int nx = curr[0] + m[0], ny = curr[1] + m[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (grid.get(nx).get(ny) == 1 || safe[nx][ny] != 0) continue;
                    safe[nx][ny] = dist;
                    d.offerLast(new int[] { nx, ny });
                }
            }
            dist++;
        }
        int left = 0, right = dist - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (check(left)) ? left : left - 1;
    }

    public boolean check(int z) {
        Deque<int[]> d = new ArrayDeque<>();
        d.offerLast(new int[] { 0, 0 });
        boolean[][] visited = new boolean[n][n];
        while (!d.isEmpty()) {
            int[] curr = d.pollFirst();
            if (visited[curr[0]][curr[1]] || safe[curr[0]][curr[1]] < z) continue;
            if (curr[0] == n - 1 && curr[1] == n - 1) return true;
            visited[curr[0]][curr[1]] = true;
            for (int[] m : moves) {
                int nx = curr[0] + m[0], ny = curr[1] + m[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] || safe[nx][ny] < z) continue;
                d.offerLast(new int[] { nx, ny });
            }
        }
        return false;
    }
}
