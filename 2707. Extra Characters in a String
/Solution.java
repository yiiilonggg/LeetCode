class Solution {
    int[] dp = new int[51];
    public int minExtraChar(String s, String[] dictionary) {
        return recurse(s, dictionary, 0);
    }
    public int recurse(String s, String[] dict, int i) {
        if (i == s.length()) return 0;
        if (dp[i] != 0) return dp[i] - 1;
        dp[i] = 2 + recurse(s, dict, i + 1);
        for (String d : dict) {
            if (i + d.length() <= s.length() && s.substring(i, i + d.length()).equals(d)) {
                dp[i] = Math.min(dp[i], 1 + recurse(s, dict, i + d.length()));
            }
        }
        return dp[i] - 1;
    }
}
