class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, n = nums.length, high = 0;
        while (right < n) {
            while (left < right && nums[right] - nums[left] > 2 * k) left++;
            while (right < n && nums[right] - nums[left] <= 2 * k) right++;
            high = Math.max(high, right - left);
        }
        return high;        
    }
}
