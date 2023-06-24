class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int curr = 0, high = 0;
        for (auto& g : gain) {
            curr += g;
            high = max(high, curr);
        }
        return high;
    }
};
