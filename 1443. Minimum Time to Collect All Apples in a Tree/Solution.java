class Solution {
    public List<Integer>[] graph;
    public List<Boolean> apple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        apple = hasApple;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return Math.max(0, dfs(0, -1) - 2);
    }
    private int dfs(int curr, int parent) {
        List<Integer> neighbours = graph[curr];
        int steps = 0;
        for (int neighbour : neighbours) {
            if (neighbour == parent) continue;
            steps += dfs(neighbour, curr);
        }
        return (apple.get(curr) || steps != 0) ? steps + 2 : steps;
    }
}