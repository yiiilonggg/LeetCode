class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long high = 0, curr = 0;
        for (int i = n - 1; i >= 0; i--) {
            curr += nums[i];
            if (i == 0 || nums[i] < nums[i - 1]) {
                high = Math.max(curr, high);
                if (i > 0 && curr < nums[i - 1]) curr = 0;
            }
        }
        return high;
    }
}
