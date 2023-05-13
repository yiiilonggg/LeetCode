class Solution {
    public long maximumOr(int[] nums, int k) {
        if (nums.length == 1) return (nums[0] * 1L) << k;
        int high = 0;
        long res = 0;
        List<Long> p = new ArrayList<>();
        int[] bits = new int[32];
        for (int n : nums) {
            int i;
            for (i = 0; (1L << i) <= n; i++) if (((1L << i) & n) > 0) bits[i]++;
            if (i > high) {
                p = new ArrayList<>();
                p.add(1L * n);
                high = i;
            } else if (i == high) {
                p.add(1L * n);
            }
        }
        for (long q : p) {
            long r = q << k;
            for (int i = 0; i < 32; i++) {
                if (bits[i] == 0 || ((1L << i) & r) > 0) continue;
                if ((q & (1L << i)) > 0 && bits[i] == 1) continue;
                r |= (1L << i);
            }
            res = Math.max(res, r);
        }
        return res;
    }
}