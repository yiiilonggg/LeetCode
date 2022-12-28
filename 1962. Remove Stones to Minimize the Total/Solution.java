class Solution {
    public int minStoneSum(int[] piles, int k) {
        int res = 0;
        int[] counts = new int[10001];
        for (int p : piles) counts[p]++;
        for (int i = 10000; i > 1 && k > 0; i--) {
            if (counts[i] == 0) continue;
            counts[floor(i)] += Math.min(k, counts[i]);
            if (k >= counts[i]) {
                k -= counts[i];
                counts[i] = 0;
            } else {
                counts[i] -= k;
                k = 0;
            }
        }
        for (int i = 0; i < 10001; i++) {
            if (counts[i] == 0) continue;
            res += i * counts[i];
        }
        return res;
    }
    public int floor(int x) {
        return (int) ((x + 1) / 2);
    }
}
