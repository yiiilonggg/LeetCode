class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int high = 0;
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == headID) continue;
            graph[manager[i]].add(new int[] { i, informTime[manager[i]] });
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { headID, 0 });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            high = Math.max(high, curr[1]);
            for (int[] sub : graph[curr[0]]) {
                q.offer(new int[] { sub[0], sub[1] + curr[1] });
            }
        }
        return high;
    }
}
