class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int first = fruits[0], second = fruits[1], res = 2;
        for (int i = 2; i < n; i++) {
            if (fruits[i] == fruits[i - 1] || fruits[i] == first || fruits[i] == second) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int pointer = i - 1;
                first = fruits[i];
                second = fruits[i - 1];
                while (pointer > 0 && fruits[pointer - 1] == fruits[pointer]) pointer--;
                dp[i] = i - pointer + 1;
            }
        }
        for (int d : dp) res = Math.max(res, d);
        return res;
    }
}