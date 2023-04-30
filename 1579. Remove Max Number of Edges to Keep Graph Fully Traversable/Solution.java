class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UFDS a = new UFDS(n), b = new UFDS(n);
        int res = 0;
        for (int[] e : edges) {
            if (e[0] != 3) continue;
            if (a.same(e[1], e[2])) res++;
            a.union(e[1], e[2]);
            b.union(e[1], e[2]);
        }
        if (a.sets == 1) return edges.length - n + 1;
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (a.same(e[1], e[2])) res++;
                a.union(e[1], e[2]);
            } else if (e[0] == 2) {
                if (b.same(e[1], e[2])) res++;
                b.union(e[1], e[2]);
            }
        }
        return (a.sets > 1 || b.sets > 1) ? -1 : res;
    }
}

class UFDS {
    int[] parent, rank;
    int sets;

    public UFDS(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        sets = n;
        for (int i = 0; i < n + 1; i++) parent[i] = i;
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
        sets--;
    }
}