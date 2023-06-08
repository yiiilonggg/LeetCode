class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0, n = grid[0].size();
        for (auto& row : grid) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (row[mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            count += n - left;
        }
        return count;
    }
};
