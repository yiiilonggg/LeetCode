class Solution {
    public boolean canJump(int[] nums) {
        int high = 0, curr = 0, n = nums.length;
        while (curr <= high) {
            high = Math.max(high, curr + nums[curr]);
            curr++;
            if (high >= n - 1) return true;
        }
        return false;
    }
}
