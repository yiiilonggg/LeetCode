class Solution {
    List[] graph;
    Map<Integer, Set<Integer>> g;
    int[] parent;
    int res;
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1, count = 0;
        res = 0;
        parent = new int[n];
        graph = new List[n];
        g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            g.put(i, new HashSet<>());
        }
        g.put(-1, new HashSet<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int[] guess : guesses) g.get(guess[0]).add(guess[1]);
        fillParent(0, -1);
        for (int i = 1; i < n; i++) {
            if (g.get(parent[i]).contains(i)) count++;
        }
        if (count >= k) res++;
        List<Integer> neighbours = graph[0];
        for (int i : neighbours) dfs(i, 0, count, k);
        return res;
    }
    public void fillParent(int curr, int prev) {
        List<Integer> neighbours = graph[curr];
        parent[curr] = prev;
        for (int neighbour : neighbours) {
            if (neighbour == prev) continue;
            fillParent(neighbour, curr);
        }
    }
    public void dfs(int curr, int prev, int count, int k) {
        if (g.get(curr).contains(prev)) count++;
        if (g.get(prev).contains(curr)) count--;
        if (count >= k) res++;
        List<Integer> neighbours = graph[curr];
        for (int neighbour : neighbours) {
            if (neighbour == prev) continue;
            dfs(neighbour, curr, count, k);
        }
    }
}