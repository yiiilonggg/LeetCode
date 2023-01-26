class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // return bellmanFord(n, flights, src, dst, k);
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] f : flights) graph[f[0]].add(new int[] { f[1], f[2] });
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int cheapest = Integer.MAX_VALUE;
        while (!q.isEmpty() && k >= -1) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                if (curr[0] == dst) cheapest = Math.min(cheapest, curr[1]);
                if (visited[curr[0]] <= curr[1]) continue;
                visited[curr[0]] = curr[1];
                List<int[]> neighbours = graph[curr[0]];
                for (int[] neighbour : neighbours) q.offer(new int[] { neighbour[0], neighbour[1] + curr[1] });
            }
            k--;
        }
        if (cheapest == Integer.MAX_VALUE) return -1;
        return cheapest;
    }
    public int bellmanFord(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) temp[j] = dist[j];
            for (int[] f : flights) {
                if (dist[f[0]] == Integer.MAX_VALUE) continue;
                temp[f[1]] = Math.min(temp[f[1]], dist[f[0]] + f[2]);
            }
            dist = temp;
        }
        if (dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}