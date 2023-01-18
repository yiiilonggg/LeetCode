class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, currMax = 0, high = nums[0], currMin = 0, low = nums[0];
        for (int n : nums) {
            total += n;
            currMax = Math.max(n, currMax + n);
            high = Math.max(high, currMax);
            currMin = Math.min(n, currMin + n);
            low = Math.min(low, currMin);
        }
        if (high > 0) return Math.max(high, total - low);
        return high;
    }
}