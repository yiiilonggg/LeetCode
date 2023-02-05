class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int[] nums, int k, int mid) {
        int n = nums.length;
        for (int i = 0; i < n && k > 0; i++) {
            if (nums[i] <= mid) {
                k--;
                i++;
            }
        }
        return k == 0;
    }
}