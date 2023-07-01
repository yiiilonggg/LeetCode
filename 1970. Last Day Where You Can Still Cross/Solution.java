class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        UFDS uf = new UFDS(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        for (int i = 0; i < cells.length; i++) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1, idx = x * col + y + 1;
            grid[x][y] = 1;
            for (int[] move : moves) {
                int nx = x + move[0], ny = y + move[1], nidx = nx * col + ny + 1;
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (grid[nx][ny] == 0) continue;
                uf.union(idx, nidx);
            }
            if (y == 0) uf.union(idx, 0);
            if (y == col - 1) uf.union(idx, row * col + 1);
            if (uf.same(0, row * col + 1)) return i;
        }
        return -1;
    }
}

class UFDS {
    int[] parent, rank;

    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        if (same(x, y)) return;
        int a = find(x), b = find(y);
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[a] = b;
            if (rank[a] == rank[b]) rank[b]++;
        }
    }
}
