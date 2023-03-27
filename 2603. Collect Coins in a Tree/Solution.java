// credit to @ye15

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Set<Integer>[] graph = new Set[n];
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) graph[i] = new HashSet<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            int curr = i;
            while (graph[curr].size() == 1 && coins[curr] == 0) {
                int v = graph[curr].iterator().next();
                graph[curr].remove(v);
                graph[v].remove(curr);
                curr = v;
            }
            if (graph[curr].size() == 1) leaves.offer(curr);
        }
        for (int i = 0; i < 2; ++i) {
            for (int j = leaves.size(); j > 0; --j) {
                int curr = leaves.poll();
                if (graph[curr].size() > 0) {
                    int v = graph[curr].iterator().next();
                    graph[curr].remove(v);
                    graph[v].remove(curr);
                    if (graph[v].size() == 1) leaves.offer(v);
                }
            }
        }
        int s = 0;
        for (int i = 0; i < n; i++) s += graph[i].size();
        return s;
    }
}