class Solution {
    int dist;
    int[] res;
    List<Integer>[] redGraph, blueGraph;
    Queue<int[]> q;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        dist = 1;
        res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        redGraph = new List[n];
        blueGraph = new List[n];
        boolean[] redVisited = new boolean[n], blueVisited = new boolean[n];
        q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        q.offer(new int[] { 0, 1 });
        res[0] = 0;
        redVisited[0] = true;
        blueVisited[0] = true;
        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }
        for (int[] r : redEdges) redGraph[r[0]].add(r[1]);
        for (int[] b : blueEdges) blueGraph[b[0]].add(b[1]);
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] curr = q.poll();
                List<Integer> neighbours = curr[1] == 0 ? blueGraph[curr[0]] : redGraph[curr[0]];
                for (int neighbour : neighbours) {
                    if (curr[1] == 0) {
                        helper(blueVisited, neighbour, 1);
                    } else {
                        helper(redVisited, neighbour, 0);
                    }
                }
            }
            dist++;
        }
        for (int i = 1; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }
    public void helper(boolean[] visited, int curr, int nextColor) {
        if (visited[curr]) return;
        visited[curr] = true;
        res[curr] = Math.min(res[curr], dist);
        q.offer(new int[] { curr, nextColor });
    }
}