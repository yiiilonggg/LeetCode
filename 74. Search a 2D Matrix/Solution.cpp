class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size(), rleft = 0, rright = m - 1, cleft = 0, cright = n - 1;
        while (rleft < rright) {
            int mid = (rleft + rright) / 2;
            if (matrix[mid][n - 1] < target) {
                rleft = mid + 1;
            } else {
                rright = mid;
            }
        }
        while (cleft < cright) {
            int mid = (cleft + cright) / 2;
            if (matrix[rleft][mid] < target) {
                cleft = mid + 1;
            } else {
                cright = mid;
            }
        }
        return matrix[rleft][cleft] == target;
    }
};
