class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int n = nums.length, left = 0, right = n - 1;
        while (left < right) {
            int shift = digits(nums[right]);
            res += nums[left] * Math.pow(10, shift) + nums[right];
            left++;
            right--;
        }
        if (left == right) res += nums[left];
        return res;
    }
    public int digits(int x) {
        int d = 0;
        while (x > 0) {
            x /= 10;
            d++;
        }
        return d;
    }
}