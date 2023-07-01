class UFDS {
public:
    vector<int> parent, rank;

    UFDS(int n) {
        rank.assign(n, 0);
        for (int i = 0; i < n; i++) parent.push_back(i);
    }

    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    bool same(int x, int y) {
        return find(x) == find(y);
    }

    void join(int x, int y) {
        if (same(x, y)) return;
        int a = find(x), b = find(y);
        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[a] = b;
            if (rank[a] == rank[b]) rank[b]++;
        }
    }
};

class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        UFDS uf(row * col + 2);
        vector<vector<int>> grid(row, vector<int>(col, 0));
        vector<vector<int>> moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        for (int i = 0; i < cells.size(); i++) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1, idx = x * col + y + 1;
            grid[x][y] = 1;
            for (const auto& move : moves) {
                int nx = x + move[0], ny = y + move[1], nidx = nx * col + ny + 1;
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (grid[nx][ny] == 0) continue;
                uf.join(idx, nidx);
            }
            if (y == 0) uf.join(idx, 0);
            if (y == col - 1) uf.join(idx, row * col + 1);
            if (uf.same(0, row * col + 1)) return i;
        }
        return -1;
    }
};
