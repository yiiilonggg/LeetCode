class Solution {
    public long countPairs(int n, int[][] edges) {
        UFDS uf = new UFDS(n);
        for (int[] e : edges) uf.union(e[0], e[1]);
        int[] reps = uf.getReps();
        long res = 0;
        for (int r : reps) {
            n -= r;
            res += 1L * n * r;
        }
        return res;
    }
}

class UFDS {
    int[] parent, rank, size;
    int disjoint, n;

    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        disjoint = n;
        this.n = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
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
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
            if (rank[a] == rank[b]) rank[b]++;
        }
        disjoint--;
    }

    public int[] getReps() {
        int[] reps = new int[disjoint];
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                reps[pointer] = size[i];
                pointer++;
            }
        }
        return reps;
    }
}