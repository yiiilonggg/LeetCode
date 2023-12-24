class Solution {
public:
    vector<int> numberGame(vector<int>& nums) {
        vector<int> r;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i += 2) {
            int a = nums[i], b = nums[i + 1];
            r.push_back(b);
            r.push_back(a);
        }
        return r;
    }
};
