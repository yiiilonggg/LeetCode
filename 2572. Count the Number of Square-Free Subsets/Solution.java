class Solution {
    int[] masks = {  -1,   0,   1,   2,  -1,   4,   3,   8,  -1,  -1,
                      5,  16,  -1,  32,   9,   6,  -1,  64,  -1, 128,
                     -1,  10,  17, 256,  -1,  -1,  33,  -1,  -1, 512, 7 };
    int[][] dp = new int[1001][1 << 10];
    int mod = 1000000007;
    public int squareFreeSubsets(int[] nums) {
        return dfs(0, 0, nums);
    }

    public int dfs(int curr, int mask, int[] nums) {
        if (curr >= nums.length) return 0;
        if (dp[curr][mask] == 0) {
            dp[curr][mask] = (1 + dfs(curr + 1, mask, nums)) % mod;
            if (masks[nums[curr]] != -1 && (mask & masks[nums[curr]]) == 0) {
                dp[curr][mask] = (dp[curr][mask] + 1 + dfs(curr + 1, mask + masks[nums[curr]], nums)) % mod;
            }
        }
        return (dp[curr][mask] - 1 + mod) % mod;
    }
}