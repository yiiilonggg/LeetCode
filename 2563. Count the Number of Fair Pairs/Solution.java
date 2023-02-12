class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper + 1) - countLess(nums, lower);
    }
    public long countLess(int[] nums, int val) {
        long res = 0;
        for (int left = 0, right = nums.length - 1; left < right; left++) {
            while (left < right && nums[left] + nums[right] >= val) right--;
            res += right - left;
        }
        return res;
    }
}