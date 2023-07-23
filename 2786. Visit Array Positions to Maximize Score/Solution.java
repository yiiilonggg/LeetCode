class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long odd = -1000001, even = -1000001, curr = 0;
        if (nums[0] % 2 == 0) {
            even = nums[0];
        } else {
            odd = nums[0];
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                curr = Math.max(even + nums[i], odd + nums[i] - x);
                even = Math.max(even, curr);
            } else {
                curr = Math.max(odd + nums[i], even + nums[i] - x);
                odd = Math.max(odd, curr);
            }
        }
        return Math.max(even, odd);
    }
}
