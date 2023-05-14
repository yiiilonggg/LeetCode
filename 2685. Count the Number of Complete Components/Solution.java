class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        UFDS uf = new UFDS(n);
        Set<Integer> p = new HashSet<>();
        for (int[] e : edges) uf.union(e[0], e[1]);
        for (int i = 0; i < n; i++) {
            int q = uf.find(i);
            if (p.contains(q)) continue;
            if (uf.isCCC(q)) p.add(q);
        }
        return p.size();
    }
}

class UFDS {
    int[] parent, rank, size, edges;
    
    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        edges = new int[n];
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
        if (same(x, y)) {
            edges[find(x)]++;
            return;
        }
        int a = find(x), b = find(y);
        if (rank[a] > rank[b]) {
            parent[b] = a;
            size[a] += size[b];
            edges[a] += edges[b] + 1;
        } else {
            parent[a] = b;
            size[b] += size[a];
            edges[b] += edges[a] + 1;
            if (rank[a] == rank[b]) rank[b]++;
        }
    }
    
    public boolean isCCC(int x) {
        return edges[x] == size[x] * (size[x] - 1) / 2;
    }
}