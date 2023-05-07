class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length, l = 0;
        int[] res = new int[n], heights = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = search(heights, obstacles[i], l);
            if (idx == l) l++;
            heights[idx] = obstacles[i];
            res[i] = idx + 1;
        }
        return res;
    }
    public int search(int[] A, int target, int right) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}