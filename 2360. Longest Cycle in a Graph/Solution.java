class Solution {
    int[] visited;
    public int longestCycle(int[] edges) {
        int n = edges.length, res = -1;
        visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) res = Math.max(res, dfs(edges, i, i, 0));
        }
        return res;
    }

    public int dfs(int[] edges, int curr, int start, int depth) {
        if (curr == -1) return -1;
        if (start == curr && depth > 0) return depth;
        if (visited[curr] != -1) return -1;
        visited[curr] = 0;
        visited[curr] = dfs(edges, edges[curr], start, depth + 1);
        return visited[curr];
    }
}