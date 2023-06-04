class UFDS {
public:
    vector<int> parent, rank;
    int N;

    UFDS(int n) {
        for (int i = 0; i < n; i++) parent.push_back(i);
        rank.assign(n, 0);
        N = n;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
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
        N--;
    }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        UFDS uf(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) uf.join(i, j);
            }
        }
        return uf.N;
    }
};
