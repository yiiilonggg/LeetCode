class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int l = arr.size() / 4, prev = -1, count = 0;
        for (int n : arr) {
            if (n == prev) {
                count++;
            } else {
                if (count > l) return prev;
                count = 1;
                prev = n;
            }
        }
        return prev;
    }
};
