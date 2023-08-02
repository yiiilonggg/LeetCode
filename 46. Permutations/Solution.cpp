class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        if (nums.size() == 0) {
            vector<int> r;
            res.push_back(r);
            return res;
        }
        vector<int> foll(nums.size() - 1, 0);
        int push = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    push--;
                    continue;
                }
                foll[j + push] = nums[j];
            }
            push = 0;
            for (vector<int> prev : permute(foll)) {
                prev.push_back(nums[i]);
                res.push_back(prev);
            }
        }
        return res;
    }
};
