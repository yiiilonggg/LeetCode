class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        int n = obstacles.size(), l = 0;
        vector<int> res(n, 1), heights(n, 0);
        for (int i = 0; i < n; i++) {
            int idx = search(heights, obstacles[i], l);
            if (idx == l) l++;
            heights[idx] = obstacles[i];
            res[i] = idx + 1;
        }
        return res;
    }

    int search(vector<int>& A, int target, int right) {
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
};