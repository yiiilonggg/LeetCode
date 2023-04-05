class Solution {
    public int minimizeArrayValue(int[] nums) {
        long left = 0, right = 1000000000;
        int n = nums.length;
        while (left < right) {
            long mid = (left + right) / 2, carry = 0;
            for (int i = n - 1; i >= 0; i--) {
                carry = Math.max(nums[i] + carry - mid, 0);
            }
            if (carry == 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }
}