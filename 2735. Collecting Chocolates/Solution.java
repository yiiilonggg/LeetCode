class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) res[i] = 1L * x * i;
        for (int i = 0; i < n; i++) {
            long curr = 1L * nums[i];
            for (int j = 0; j < n; j++) {
                curr = Math.min(curr, 1L * nums[(i - j + n) % n]);
                res[j] += curr;
            }
        }
        long r = Long.MAX_VALUE;
        for (long l : res) r = Math.min(r, l);
        return r;
    }
}
