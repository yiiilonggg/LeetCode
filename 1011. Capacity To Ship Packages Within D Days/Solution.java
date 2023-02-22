class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0, n = weights.length;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + ((right - left) / 2), curr = 0, day = 1;
            for (int w : weights) {
                if (curr + w > mid) {
                    curr = 0;
                    day++;
                }
                curr += w;
            }
            if (day > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}