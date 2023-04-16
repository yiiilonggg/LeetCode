class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length, high = nums[0];
        long[] res = new long[n];
        res[0] = 1L * high + 1L * nums[0];
        for (int i = 1; i < n; i++) {
            high = Math.max(high, nums[i]);
            long conv = 1L * high + 1L * nums[i];
            res[i] = conv + res[i - 1];
        }
        return res;
    }
}