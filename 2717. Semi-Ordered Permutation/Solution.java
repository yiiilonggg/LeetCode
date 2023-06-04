class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length, oneIdx = -1, nIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneIdx = i;
            } else if (nums[i] == n) {
                nIdx = i;
            }
        }
        return (oneIdx < nIdx) ? oneIdx + (n - 1 - nIdx) : oneIdx + (n - 1 - nIdx) - 1;
    }
}
