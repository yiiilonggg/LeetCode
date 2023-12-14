class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        int r = mat.size(), c = mat[0].size(), x = 0;
        vector<int> rcount(r, 0), ccount(c, 0);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    rcount[i]++;
                    ccount[j]++;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1 && rcount[i] == 1 && ccount[j] == 1) x++;
            }
        }
        return x;
    }
};
