class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length(), res = 0, processed = 0;
        int[][] dp = new int[n][26];
        List<Integer>[] graph = new List[n];
        int[] indeg = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            indeg[e[1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int curr = q.poll();
                processed++;
                dp[curr][colors.charAt(curr) - 'a']++;
                res = Math.max(res, dp[curr][colors.charAt(curr) - 'a']);
                for (int j : graph[curr]) {
                    for (int k = 0; k < 26; k++) {
                        dp[j][k] = Math.max(dp[j][k], dp[curr][k]);
                    }
                    indeg[j]--;
                    if (indeg[j] == 0) q.offer(j);
                }
            }
        }
        return processed < n ? -1 : res;
    }
}