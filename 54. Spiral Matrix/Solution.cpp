class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        for (int left = 0, top = 0, bottom = matrix.size() - 1, right = matrix[0].size() - 1; left <= right && top <= bottom; left++, right--, top++, bottom--) {
            for (int i = left; i <= right; i++) res.push_back(matrix[top][i]);
            if (top == bottom) break;
            for (int i = top + 1; i <= bottom; i++) res.push_back(matrix[i][right]);
            if (left == right) break;
            for (int i = right - 1; i >= left; i--) res.push_back(matrix[bottom][i]);
            for (int i = bottom - 1; i >= top + 1; i--) res.push_back(matrix[i][left]);
        }
        return res;
    }
};