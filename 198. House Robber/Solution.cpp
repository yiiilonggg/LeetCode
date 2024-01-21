class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if(n==1)return nums[0];
        vector<int>dp(n,0);
        for(int i=0;i<n;i++){
            if(i>1){
                dp[i]=max(nums[i]+dp[i-2],dp[i-1]);
            }else if(i==0){
                dp[i]=nums[i];
            }else{
                dp[i]=max(dp[i-1],nums[i]);
            }
        }
        return max(dp[n-1],dp[n-2]);
    }
};
