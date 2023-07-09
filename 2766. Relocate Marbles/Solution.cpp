class Solution {
public:
    vector<int> relocateMarbles(vector<int>& nums, vector<int>& moveFrom, vector<int>& moveTo) {
        unordered_set<int> d;
        int l = moveFrom.size();
        for (const int& n : nums) d.insert(n);
        for (int i = 0; i < l; i++) {
            if (moveTo[i] == moveFrom[i]) continue;
            d.insert(moveTo[i]);
            d.erase(moveFrom[i]);
        }
        vector<int> res;
        for (const int& n : d) res.push_back(n);
        sort(begin(res), end(res));
        return res;
    }
};
