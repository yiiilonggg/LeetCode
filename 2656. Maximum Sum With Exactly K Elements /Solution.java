class Solution {
    public int maximizeSum(int[] nums, int k) {
        int high = 0;
        for (int n : nums) high = Math.max(high, n);
        return high * k + k * (k - 1) / 2;
    }
}