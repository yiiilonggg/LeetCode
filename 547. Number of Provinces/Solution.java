class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UFDS uf = new UFDS(n);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (isConnected[x][y] == 1) uf.union(x, y);
            }
        }
        return uf.N;
    }
}

class UFDS {
    int[] parent, rank;
    int N;

    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
        N = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
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
        N--;
    }
}
