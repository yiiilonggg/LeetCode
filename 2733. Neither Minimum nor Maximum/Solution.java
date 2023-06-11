class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) return -1;
        int high = 0, low = 101;
        for (int n : nums) {
            high = Math.max(high, n);
            low = Math.min(low, n);
        }
        for (int n : nums) {
            if (high > n && low < n) return n;
        }
        return -1;
    }
}
