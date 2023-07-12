class Solution {
    int[] loop;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        loop = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, new HashSet<>())) res.add(i);
        }
        return res;
    }

    public boolean dfs(int[][] graph, int curr, Set<Integer> visited) {
        if (visited.contains(curr)) return false;
        if (loop[curr] != 0) return loop[curr] == 1;
        visited.add(curr);
        for (int neighbour : graph[curr]) {
            if (!dfs(graph, neighbour, visited)) {
                loop[curr] = -1;
                return false;
            }
        }
        visited.remove(curr);
        loop[curr] = 1;
        return true;
    }
}
