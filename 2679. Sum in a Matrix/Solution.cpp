class Solution {
public:
    int matrixSum(vector<vector<int>>& nums) {
        int r = nums.size(), c = nums[0].size(), res = 0;
        vector<priority_queue<int>> pqs;
        for (int i = 0; i < r; i++) {
            priority_queue<int> pq;
            for (int j = 0; j < c; j++) {
                pq.push(nums[i][j]);
            }
            pqs.push_back(pq);
        }
        for (int i = 0; i < c; i++) {
            int high = 0;
            for (int j = 0; j < r; j++) {
                high = max(high, pqs[j].top());
                pqs[j].pop();
            }
            res += high;
        }
        return res;
    }
};