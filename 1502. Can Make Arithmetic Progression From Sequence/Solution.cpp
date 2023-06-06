class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(begin(arr), end(arr));
        int diff = arr[1] - arr[0], n = arr.size();
        for (int i = 2; i < n; i++) {
            if (diff != arr[i] - arr[i - 1]) return false;
        }
        return true;
    }
};
