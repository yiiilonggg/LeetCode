class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        auto cmp = [](const auto a, const auto b) { return a > b; };
        priority_queue<int, vector<int>, decltype(cmp)> pq(cmp);
        for (int n : nums) { 
            pq.push(n);
            if (pq.size() > k) pq.pop();
        }
        return pq.top();
    }
};
