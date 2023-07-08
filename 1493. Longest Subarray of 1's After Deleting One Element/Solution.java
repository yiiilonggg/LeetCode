class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, high = 0, zero = 0, left = 0;
        for (int right = 0; right < n; right++) {
            zero += (nums[right] == 0) ? 1 : 0;
            while (zero > 1) {
                zero -= (nums[left] == 0) ? 1 : 0;
                left++;
            }
            high = Math.max(high, right - left);
        }
        return high;
    }
}
