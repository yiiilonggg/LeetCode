class Solution {
public:
    vector<int> colorTheArray(int n, vector<vector<int>>& queries) {
        int l = queries.size(), a = 0;
        vector<int> cols(n, 0), res(l, 0);
        for (int i = 0; i < l; i++) {
            int j = queries[i][0], c = queries[i][1];
            if (c != cols[j]) {
                if (j > 0 && cols[j - 1] != 0 && cols[j - 1] == cols[j] && cols[j - 1] != c) a--;
                if (j < n - 1 && cols[j + 1] != 0 && cols[j + 1] == cols[j] && cols[j + 1] != c) a--;
                cols[j] = c;
                if (j > 0 && cols[j - 1] == c) a++;
                if (j < n - 1 && cols[j + 1] == c) a++;
            }
            res[i] = a;
        }
        return res;
    }
};