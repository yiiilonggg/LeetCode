class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        int res = 0;
        for (int d : derived) res ^= d;
        return res == 0;
    }
};