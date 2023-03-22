class Solution {
    public int minScore(int n, int[][] roads) {
        UFDS uf = new UFDS(n);
        for (int[] r : roads) {
            uf.union(r[0], r[1], r[2]);
        }
        return uf.getDist(1);
    }
}

class UFDS {
    int[] parent, rank, dist;

    public UFDS(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            dist[i] = 10001;
        }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y, int w) {
        int a = find(x), b = find(y);
        dist[b] = Math.min(Math.min(dist[b], dist[a]), w);
        dist[a] = Math.min(Math.min(dist[a], dist[b]), w);
        if (same(x, y)) return;
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
    }

    public int getDist(int x) {
        return dist[find(x)];
    }
}