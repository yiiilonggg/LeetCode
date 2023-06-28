class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        boolean[] visited = new boolean[n];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> (a[0] > b[0]) ? 1 : (a[0] < b[0]) ? -1 : 0);
        List<double[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[] { edges[i][1], Math.log(succProb[i]) });
            graph[edges[i][1]].add(new double[] { edges[i][0], Math.log(succProb[i]) });
        }
        pq.offer(new double[] { 0, start });
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            if (visited[(int)curr[1]]) continue;
            visited[(int)curr[1]] = true;
            if ((int)curr[1] == end) return Math.exp(-curr[0]);
            for (double[] neighbour : graph[(int)curr[1]]) {
                if (visited[(int)neighbour[0]]) continue;
                pq.offer(new double[] { curr[0] - neighbour[1], neighbour[0] });
            }
        }
        return 0;
    }
}
