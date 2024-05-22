class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        int n=nums.size(),r=0;
        for(int i=1;i<=(1<<n)-1;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if((i&(1<<j)))c^=nums[j];
            }
            r+=c;
        }
        return r;
    }
};
