class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] combined = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = scores[i];
            combined[i][1] = ages[i];
        }
        Arrays.sort(combined, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = combined[i][0];
            for (int j = 0; j < i; j++) {
                if (combined[j][0] <= combined[i][0]) dp[i] = Math.max(dp[i], dp[j] + combined[i][0]);
            }
        }
        int high = 0;
        for (int d : dp) high = Math.max(d, high);
        return high;
    }
}