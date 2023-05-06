class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, mod = 1000000007, left = 0, n = nums.length, right = n - 1;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) power[i] = (power[i - 1] << 1) % mod;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + power[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}
