class Solution {
    public int searchInsert(int[] nums, int target) {
        /**
        int res = Arrays.binarySearch(nums, target);
        if (res >= 0) return res;
        return -1 * (res + 1);
         */
        int n = nums.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }
}