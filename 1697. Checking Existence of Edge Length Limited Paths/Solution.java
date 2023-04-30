class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UFDS uf = new UFDS(n);
        int q = queries.length, e = edgeList.length, j = 0;
        int[][] qIdx = new int[q][4];
        for (int i = 0; i < q; i++) {
            qIdx[i][0] = queries[i][0];
            qIdx[i][1] = queries[i][1];
            qIdx[i][2] = queries[i][2];
            qIdx[i][3] = i;
        }
        boolean[] res = new boolean[q];
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(qIdx, (a, b) -> a[2] - b[2]);
        for (int[] query : qIdx) {
            while (j < e && edgeList[j][2] < query[2]) {
                uf.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            res[query[3]] = uf.same(query[0], query[1]);
        }
        return res;
    }
}

class UFDS {
    int[] parent, rank;

    public UFDS(int n) {
        parent = new int[n];
        rank = new int[n];
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
    }
}