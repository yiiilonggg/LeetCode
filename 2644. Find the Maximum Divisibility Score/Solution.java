class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int high = 0, res = 1000000001;
        for (int d : divisors) {
            int curr = 0;
            for (int n : nums) {
                if (n % d == 0) curr++;
            }
            if (curr > high) {
                res = d;
                high = curr;
            } else if (curr == high) {
                res = Math.min(res, d);
            }
        }
        return res;
    }
}