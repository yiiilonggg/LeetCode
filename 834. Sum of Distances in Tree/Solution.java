class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] size = new int[n], dp = new int[n], res = new int[n];
        findSizeAndDP(0, -1, size, dp, graph);
        dfs(0, -1, size, dp, res, graph);
        return res;
    }

    public void findSizeAndDP(int curr, int parent, int[] size, int[] dp, List<Integer>[] graph) {
        size[curr] = 1;
        for (int neighbour : graph[curr]) {
            if (neighbour == parent) continue;
            findSizeAndDP(neighbour, curr, size, dp, graph);
            size[curr] += size[neighbour];
            dp[curr] += dp[neighbour] + size[neighbour];
        }
    }

    public void reroot(int fromNode, int toNode, int[] size, int[] dp) {
        size[fromNode] -= size[toNode];
        dp[fromNode] -= dp[toNode] + size[toNode];
        size[toNode] += size[fromNode];
        dp[toNode] += dp[fromNode] + size[fromNode];
    }

    public void dfs(int curr, int parent, int[] size, int[] dp, int[] res, List<Integer>[] graph) {
        res[curr] = dp[curr];
        for (int neighbour : graph[curr]) {
            if (neighbour == parent) continue;
            reroot(curr, neighbour, size, dp);
            dfs(neighbour, curr, size, dp, res, graph);
            reroot(neighbour, curr, size, dp);
        }
    }
}
