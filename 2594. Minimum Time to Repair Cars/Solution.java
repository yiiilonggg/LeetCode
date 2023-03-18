class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            int c = 0;
            long mid = left + (right - left) / 2;
            for (int r : ranks) c += Math.sqrt(mid / r);
            if (c < cars) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}