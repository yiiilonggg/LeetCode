class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, n = nums.length, prev = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                res += (i - prev) * (i - prev - 1) / 2;
                prev = i;
            }
        }
        res += (n - prev) * (n - prev - 1) / 2;
        return res;
    }
}