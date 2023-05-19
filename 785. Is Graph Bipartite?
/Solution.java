class Solution {
    int[][] g;
    int[] col;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        col = new int[n];
        g = graph;
        for (int i = 0; i < n; i++) {
            if (col[i] != 0) continue;
            if (!dfs(i, 1)) return false;
        }
        return true;
    }
    public boolean dfs(int curr, int color) {
        if (col[curr] != 0) return col[curr] == color;
        col[curr] = color;
        for (int neighbour : g[curr]) {
            if (!dfs(neighbour, (color == 2) ? 1 : 2)) return false;
        }
        return true;
    }
}