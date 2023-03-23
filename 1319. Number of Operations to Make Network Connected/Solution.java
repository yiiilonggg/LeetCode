class Solution {
    public int makeConnected(int n, int[][] connections) {
        UFDS uf = new UFDS(n);
        for (int[] c : connections) uf.union(c[0], c[1]);
        return (uf.disjoint - 1 > uf.free) ? -1 : uf.disjoint - 1;
    }
}

class UFDS {
    int[] parent, rank;
    int disjoint, free;

    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
        disjoint = n;
        free = 0;
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
        if (same(x, y)) {
            free++;
            return;
        }
        int a = find(x), b = find(y);
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
        disjoint--;
    }
}