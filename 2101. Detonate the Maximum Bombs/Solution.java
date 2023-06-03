class Solution {
    List<Integer>[] graph;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length, high = 0;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int a = bombs[j][0], b = bombs[j][1];
                if (1L * (x - a) * (x - a) + 1L * (y - b) * (y - b) > 1L * r * r) continue;
                graph[i].add(j);
            }
        }
        for (int i = 0; i < n; i++) {
            high = Math.max(high, dfs(i, new HashSet<>()));
        }
        return high;
    }
    public int dfs(int curr, Set<Integer> seen) {
        if (seen.contains(curr)) return 0;
        seen.add(curr);
        int total = 1;
        for (int neighbour : graph[curr]) total += dfs(neighbour, seen);
        return total;
    }
}
