class Solution {
public:
    vector<int> getGoodIndices(vector<vector<int>>& variables, int target) {
        vector<int> res;
        int l = variables.size();
        for (int i = 0; i < l; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], m = variables[i][3];
            int d = 1, e = 1;
            for (int j = 0; j < b; j++) {
                d = (d * a) % 10;
            }
            for (int j = 0; j < c; j++) {
                e = (e * d) % m;
            }
            if (e == target) res.push_back(i);
        }
        return res;
    }
};
