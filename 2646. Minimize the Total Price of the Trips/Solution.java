class Solution {
    public int[] visited, price;
    public List<Integer>[] graph;
    public int n;
    public Map<Integer, Map<Boolean, Integer>> memo;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        visited = new int[n];
        this.price = price;
        graph = new List[n];
        this.n = n;
        memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            memo.put(i, new HashMap<>());
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int[] t : trips) {
            dfs(t[0], t[1], -1);
            visited[t[1]]++;
        }
        return backtrack(0, -1, false);
    }
    public boolean dfs(int curr, int target, int prev) {
        if (curr == target) return true;
        for (int neighbour : graph[curr]) {
            if (neighbour == prev) continue;
            if (dfs(neighbour, target, curr)) {
                visited[curr]++;
                return true;
            }
        }
        return false;
    }
    
    public int backtrack(int curr, int prev, boolean prevHalved) {
        if (memo.containsKey(curr) && memo.get(curr).containsKey(prevHalved)) return memo.get(curr).get(prevHalved);
        int total = price[curr] * visited[curr], half = total;
        for (int neighbour : graph[curr]) {
            if (neighbour == prev) continue;
            total += backtrack(neighbour, curr, false);
        }
        if (!prevHalved) {
            half /= 2;
            for (int neighbour : graph[curr]) {
                if (neighbour == prev) continue;
                half += backtrack(neighbour, curr, true);
            }
        }
        if (prevHalved) {
            memo.get(curr).put(prevHalved, total);
        } else {
            memo.get(curr).put(prevHalved, Math.min(half, total));
        }
        return (prevHalved) ? total : Math.min(half, total);
    }
}