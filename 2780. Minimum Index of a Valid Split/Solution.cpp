class Solution {
public:
    int minimumIndex(vector<int>& nums) {
        unordered_map<int, int> d;
        int x = 0, high = 0, n = nums.size();
        for (int num : nums) {
            d[num] = (d.find(num) == d.end()) ? 1 : d[num] + 1;
            if (d[num] > high) {
                high = d[num];
                x = num;
            }
        }
        int left = 0, right = high;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == x) {
                left++;
                right--;
            }
            if (left > (i + 1) / 2 && right > (n - i - 1) / 2) return i;
        }
        return -1;
    }
};
