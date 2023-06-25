class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length, left = -1;
        long MOD = 1000000007, count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (left != -1) {
                    count = (count == 0) ? 1L * (i - left) : (count * (i - left)) % MOD;
                }
                left = i;
            }
        }
        if (count == 0 && left != -1) return 1;
        return (int) count;
    }
}
