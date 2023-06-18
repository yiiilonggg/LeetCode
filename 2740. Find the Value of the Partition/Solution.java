class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int low = 1000000007, n = nums.length;
        for (int i = 1; i < n; i++) {
            low = Math.min(low, nums[i] - nums[i - 1]);
        }
        return low;
    }
}
