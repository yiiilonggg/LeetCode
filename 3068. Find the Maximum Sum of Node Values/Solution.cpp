class Solution {
public:
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        int n=nums.size();
        long long o=-1e6,e=0;
        for(int i=0;i<n;i++){
            long long to=(nums[i]^k)+e,ko=nums[i]+o,te=(nums[i]^k)+o,ke=nums[i]+e;
            o=max(to,ko);
            e=max(te,ke);
        }
        return e;
    }
};
