class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n], prefixPrefix = new long[n];
        prefix[0] = nums[0] * 1L;
        long mod = 1000000007, res = (((1L * nums[0] * nums[0]) % mod) * (1L * prefix[0])) % mod;
        for (int i = 1; i < n; i++) {
            prefix[i] = (i > 1) ? (prefixPrefix[i - 2] + prefix[i - 1] + nums[i]) % mod : (prefix[i - 1] + nums[i]) % mod;
            prefixPrefix[i - 1] = (i > 1) ? (prefixPrefix[i - 2] + prefix[i - 1]) % mod : prefix[i - 1];
            long p = (((1L * nums[i] * nums[i]) % mod) * (1L * prefix[i])) % mod;
            res = (res + p) % mod;
        }
        return (int) res;
    }
}