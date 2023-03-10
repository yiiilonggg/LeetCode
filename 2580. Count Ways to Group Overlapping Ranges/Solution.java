class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int upper = -1, count = 0;
        for (int[] r : ranges) {
            if (r[0] <= upper) {
                upper = Math.max(upper, r[1]);
            } else {
                count++;
                upper = r[1];
            }
        }
        long res = 1, MOD = 1000000007;
        for (int i = 0; i < count; i++) {
            res = (res * 2) % MOD;
        }
        return (int) res;
    }
}