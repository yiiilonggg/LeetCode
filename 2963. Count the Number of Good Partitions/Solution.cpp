class Solution {
public:
    int numberOfGoodPartitions(vector<int>& nums) {
        map<int, vector<int>> seen;
        int l = nums.size();
        for (int i = 0; i < l; i++) {
            if (seen.find(nums[i]) == seen.end()) {
                seen[nums[i]] = {i, i};
            } else {
                seen[nums[i]][1] = i;
            }
        }
        vector<vector<int>> vec;
        for (auto [k, v] : seen) vec.push_back(v);
        sort(vec.begin(), vec.end(), [] (const auto& a, const auto& b) {
            return (a[0] == b[0]) ? a[0] > b[0] : a[0] < b[0];
        });
        vector<vector<int>> ints;
        for (vector<int> ve : vec) {
            if (ints.empty()) {
                ints.push_back(ve);
            } else {
                if (ints[ints.size() - 1][1] >= ve[0]) {
                    ints[ints.size() - 1][1] = max(ints[ints.size() - 1][1], ve[1]);
                } else {
                    ints.push_back(ve);
                }
            }
        }
        long res = 1;
        /*
        1 -> 2^0
        1 2; 12 -> 2^1
        1 2 3; 12 3; 1 23; 123 -> 2^2
        1 2 3 4; 12 3 4; 1 23 4; 1 2 34; 12 34; 123 4; 1 234; 1234 -> 2^3
        */
        for (int i = 0; i < ints.size() - 1; i++) {
            res = (res * 2) % 1000000007;
        }
        return res;
    }
};
