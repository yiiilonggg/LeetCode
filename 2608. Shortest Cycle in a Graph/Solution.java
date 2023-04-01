class Solution {
    int res = 1001;
    List<Integer>[] graph;
    int[] visited;
    boolean[] path;
    public int findShortestCycle(int n, int[][] edges) {
        graph = new List[n];
        visited = new int[n];
        path = new boolean[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) dfs(i, -1, 0);
        }
        return res == 1001 ? -1 : res;
    }
    public void dfs(int curr, int prev, int depth) {
        if (path[curr]) {
            res = Math.min(res, depth - visited[curr]);
            return;
        }
        if (depth > res) return;
        visited[curr] = depth;
        path[curr] = true;
        for (int neighbour : graph[curr]) {
            if (neighbour == prev) continue;
            dfs(neighbour, curr, depth + 1);
        }
        path[curr] = false;
    }
}