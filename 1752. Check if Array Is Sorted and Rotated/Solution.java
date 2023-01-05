class Solution {
    public boolean check(int[] nums) {
        int i = 1, n = nums.length;
        while (i < n && nums[i] >= nums[i - 1]) i++;
        if (i == n) return true;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] < nums[j - 1]) return false;
        }
        return nums[0] >= nums[n - 1];
    }
}