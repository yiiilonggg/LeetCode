class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, low = nums[0], high = nums[n - 1];
        return Math.min(nums[n - 3] - low, Math.min(high - nums[2], nums[n - 2] - nums[1]));
    }
}