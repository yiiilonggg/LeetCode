class Solution {
    public int[] countBits(int n) {
        if (n == 0) return new int[] { 0 };
        if (n == 1) return new int[] { 0, 1 };
        int[] res = new int[n + 1];
        res[1] = 1;
        int left = 1, gap = 1;
        for (int right = 2; right <= n; right++) {
            if (right == left + gap) {
                res[right] = 1;
                left = right;
                gap *= 2;
            } else {
                res[right] = res[right - gap] + 1;
            }
        }
        return res;
    }
}
