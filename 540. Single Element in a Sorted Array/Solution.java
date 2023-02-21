class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, left = 0, right = n - 1;
        if (n == 1) return nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }
}