class Solution {
public:
    vector<int> findIntersectionValues(vector<int>& nums1, vector<int>& nums2) {
        set<int> a, b;
        for (int n : nums1) a.insert(n);
        for (int n : nums2) b.insert(n);
        int c = 0, d = 0;
        for (int n : nums1) {
            if (b.find(n) != b.end()) c++;
        }
        for (int n : nums2) {
            if (a.find(n) != a.end()) d++;
        }
        return {c, d};
    }
};
