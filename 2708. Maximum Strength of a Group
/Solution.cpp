class Solution {
public:
    long long maxStrength(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        priority_queue<int, vector<int>, greater<int>> pq;
        long res = 1;
        int count = 0;
        for (int n : nums) {
            if (n >= 1) {
                res *= n;
                count++;
            } else {
                pq.push(n);
            }
        }
        while (pq.size() > 1) {
            int curr = pq.top();
            pq.pop();
            if (curr < 0) {
                if (pq.top() < 0) {
                    res *= 1L * curr * pq.top();
                    count += 2;
                    pq.pop();
                } else {
                    if (count == 0) res = 0;
                }
            } else {
                if (count == 0) res = 0;
            }
        }
        return res;
    }
};
