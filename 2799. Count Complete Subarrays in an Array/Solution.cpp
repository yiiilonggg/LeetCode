class Solution {
public:
    int res = 0, n;
    unordered_map<int, int> counter;
    unordered_map<int, unordered_set<int>> seen;
    int countCompleteSubarrays(vector<int>& nums) {
        for (int num : nums) counter[num]++;
        n = counter.size();
        int m = nums.size();
        if (n == 1) return m * (m + 1) / 2;
        if (n == m) return 1;
        count(nums, 0, m - 1);
        return res;
    } 
    void count(vector<int>& nums, int left, int right) {
        if (left > right) return;
        if (seen.find(left) != seen.end() && seen[left].find(right) != seen[left].end()) return;
        if (seen.find(left) == seen.end()) {
            unordered_set<int> s;
            seen[left] = s;
        }
        seen[left].insert(right);
        if (counter.size() < n) return;
        res++;
        counter[nums[left]]--;
        if (counter[nums[left]] == 0) counter.erase(nums[left]);
        count(nums, left + 1, right);
        counter[nums[left]]++;
        counter[nums[right]]--;
        if (counter[nums[right]] == 0) counter.erase(nums[right]);
        count(nums, left, right - 1);
        counter[nums[right]]++;
    }
};
