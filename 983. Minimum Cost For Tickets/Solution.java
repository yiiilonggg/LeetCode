class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> t = new HashSet<>();
        for (int d : days) t.add(d);
        for (int i = 1; i <= days[days.length - 1]; i++) {
            if (t.contains(i)) {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[days[days.length - 1]];
    }
}