class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = 100000000000000L;
        int n = time.length;
        while (left < right) {
            long mid = (left + right) / 2, count = 0;
            for (int i = 0; i < n; i++) {
                count += mid / time[i];
                if (count > totalTrips) break;
            }
            if (count < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}