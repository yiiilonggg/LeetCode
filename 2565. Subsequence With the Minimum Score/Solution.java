class Solution {
    public int minimumScore(String s, String t) {
        int m = s.length(), n = t.length(), left = 0, right = n - 1;
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            if (left < n && s.charAt(i) == t.charAt(left)) left++;
            dp[i] = left;
        }
        int res = n - left;
        for (int i = m - 1; i >= 0; i--) {
            res = Math.min(res, Math.max(0, right - dp[i] + 1));
            if (right > 0 && s.charAt(i) == t.charAt(right)) right--;
        } 
        return Math.min(res, right + 1);
    }
}