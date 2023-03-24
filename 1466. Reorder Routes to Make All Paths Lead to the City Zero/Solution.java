class Solution {
    public int minReorder(int n, int[][] connections) {
        UFDS uf = new UFDS(n);
        Deque<int[]> d = new ArrayDeque<>();
        for (int[] c : connections) {
            int a = uf.find(c[0]), b = uf.find(c[1]);
            if (a == 0 || b == 0) {
                uf.union(a, b);
            } else {
                d.offerLast(c);
            }
        }
        while (!d.isEmpty()) {
            int[] c = d.pollLast();
            int a = uf.find(c[0]), b = uf.find(c[1]);
            if (a == 0 || b == 0) {
                uf.union(a, b);
            } else {
                d.offerFirst(c);
            }
        }
        return uf.count;
    }
}

class UFDS {
    int[] parent;
    int count;

    public UFDS(int n) {
        parent = new int[n];
        count = 0;
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
        if (a == 0) {
            count++;
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}