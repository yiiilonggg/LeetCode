class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = (s.charAt(i) == 'R') ? nums[i] + d : nums[i] - d;
        }
        Arrays.sort(nums);
        long MOD = 1000000007, res = 0, prefix = 0, prev = nums[0];
        for (int i = 1; i < n; i++) {
            res = (res + prefix + (i * Math.abs(nums[i] - prev) % MOD)) % MOD;
            prefix = (prefix + (i * Math.abs(nums[i] - prev)) % MOD) % MOD;
            prev = nums[i];
        }
        return (int) res;
    }
}
