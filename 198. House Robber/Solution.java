class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] memo = new int[nums.length + 1];
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i - 1] + nums[i], memo[i]);
        }
        return memo[nums.length];
    }
}
