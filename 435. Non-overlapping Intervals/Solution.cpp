class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(begin(intervals), end(intervals), [](const auto& a, const auto& b) { return a[1] < b[1]; });
        int count = 0, upper = intervals[0][0] - 1;
        for (const auto& i : intervals) {
            if (i[0] < upper) {
                count++;
            } else {
                upper = i[1];
            }
        }
        return count;
    }
};
