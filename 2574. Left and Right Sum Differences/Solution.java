class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n], ans = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] = nums[i] + prefix[i - 1];
        int right = prefix[n - 1];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs((prefix[i] - nums[i]) - (right - prefix[i]));
        }
        return ans;
    }
}