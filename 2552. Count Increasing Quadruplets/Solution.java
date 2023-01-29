class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        long res = 0;
        for (int j = 0; j < n; j++) {
            int prevSmall = 0;
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    prevSmall++;
                    res += dp[i];
                } else {
                    dp[i] += prevSmall;
                }
            }
        }
        return res;
    }
}