class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = (nums[0] >= target) ? 1 : 0, curr = 0, low = n, total = 0;
        for (int right = 0; right < n; right++) {
            curr += nums[right];
            total += nums[right];
            while (left < right && curr >= target) {
                low = Math.min(low, right - left + 1);
                curr -= nums[left];
                left++;
            }
        }
        while (left < n && curr >= target) {
            low = Math.min(low, n - left);
            curr -= nums[left];
            left++;
        }
        return (total < target) ? 0 : low;
    }
}
