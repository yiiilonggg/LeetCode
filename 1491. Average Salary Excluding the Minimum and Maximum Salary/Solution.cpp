class Solution {
public:
    double average(vector<int>& salary) {
        int total = 0, high = 0, low = 1e7;
        for (auto s : salary) {
            total += s;
            high = max(high, s);
            low = min(low, s);
        }
        return double(total - high - low) / (salary.size() - 2);
    }
};