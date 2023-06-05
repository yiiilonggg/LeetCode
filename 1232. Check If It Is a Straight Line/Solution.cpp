class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        vector<int> gradient = grad(coordinates[0], coordinates[1]);
        int n = coordinates.size();
        for (int i = 2; i < n; i++) {
            vector<int> curr = grad(coordinates[0], coordinates[i]);
            if (curr[0] * gradient[1] != curr[1] * gradient[0]) return false;
        }
        return true;
    }

    vector<int> grad(vector<int> first, vector<int> second) {
        vector<int> res = { first[0] - second[0], first[1] - second[1] };
        return res;
    }
};
