class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000, n = piles.length;
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int i = 0; i < n; i++) {
                count = (piles[i] % mid == 0) ? count + piles[i] / mid : count + 1 + piles[i] / mid;
            }
            if (count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}