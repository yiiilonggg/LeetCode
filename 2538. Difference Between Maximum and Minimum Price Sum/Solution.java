class Solution {
    List<Integer>[] graph;
    int[] prices;
    long[] subtree;
    long res;
    public long maxOutput(int n, int[][] edges, int[] price) {
        res = 0;
        graph = new List[n];
        prices = price;
        subtree = new long[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        fillSubtree(0, -1);
        dfs(0, -1, 0);
        return res;
    }
    public long fillSubtree(int curr, int parent) {
        long subRes = 0;
        List<Integer> neighbours = graph[curr];
        for (int neighbour : neighbours) {
            if (neighbour == parent) continue;
            subRes = Math.max(subRes, fillSubtree(neighbour, curr));
        }
        subtree[curr] = subRes + prices[curr];
        return subtree[curr];
    }

    public void dfs(int curr, int parent, long fromParent) {
        int firstNode = -1, secondNode = -1;
        long firstPath = 0, secondPath = 0;
        List<Integer> neighbours = graph[curr];
        for (int neighbour : neighbours) {
            if (neighbour == parent) continue;
            if (subtree[neighbour] > firstPath) {
                secondNode = firstNode;
                secondPath = firstPath;
                firstNode = neighbour;
                firstPath = subtree[neighbour];
            } else if (subtree[neighbour] > secondPath) {
                secondNode = neighbour;
                secondPath = subtree[neighbour];
            }
        }
        res = Math.max(res, Math.max(fromParent, firstPath));
        for (int neighbour : neighbours) {
            if (neighbour == parent) continue;
            if (neighbour == firstNode) {
                dfs(neighbour, curr, prices[curr] + Math.max(secondPath, fromParent));
            } else {
                dfs(neighbour, curr, prices[curr] + Math.max(firstPath, fromParent));
            }
        }
    }
}