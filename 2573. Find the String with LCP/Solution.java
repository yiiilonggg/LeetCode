// credit to: @timetoai

class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        UFDS uf = new UFDS(n);

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] + i != n) return "";
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] + j > n || lcp[i][j] != lcp[j][i]) return "";
                if (lcp[i][j] == 0) continue;
                if (j + 1 < n && lcp[i + 1][j + 1] + 1 != lcp[i][j]) return "";
                uf.union(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] == 0 && uf.same(i, j)) return "";
                if (lcp[i][j] > 0 && lcp[i][j] + j < n && uf.same(i + lcp[i][j], j + lcp[i][j])) return "";
            }
        }
        char[] res = new char[n];
        Arrays.fill(res, 'A');
        char c = 'a';
        for (int i = 0; i < n; i++) {
            int p = uf.find(i);
            if (res[p] != 'A') {
                res[i] = res[p];
            } else {
                if (c > 'z') return "";
                res[i] = c;
                c++;
            }
        }
        return new String(res);
    }
}

class UFDS {
    int[] parent;

    public UFDS(int n) {
        parent = new int[n];
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
        parent[a] = Math.min(a, b);
        parent[b] = Math.min(a, b);
    }
}