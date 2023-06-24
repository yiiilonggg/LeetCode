class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long curr = 0;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < Math.min(n, 2 * k); i++) curr += nums[i];
        for (int i = k; i < n - k; i++) {
            curr += nums[i + k];
            res[i] = (int) (curr / (2 * k + 1));
            curr -= nums[i - k];
        }
        return res;
    }
}
