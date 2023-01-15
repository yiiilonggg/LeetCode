class Solution {
    int[] parent;
    int[] count;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length, res = n;
        parent = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            count[i] = 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int aMax = Math.max(vals[a[0]], vals[a[1]]), bMax = Math.max(vals[b[0]], vals[b[1]]);
            return aMax - bMax;
        });
        for (int[] edge : edges) pq.offer(edge);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = find(edge[0]), y = find(edge[1]);
            if (vals[x] == vals[y]) {
                res += count[x] * count[y];
                parent[x] = y;
                count[y] += count[x];
            } else if (vals[x] > vals[y]) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
        return res;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}