class Solution {
public:
    int specialArray(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n=nums.size(),c;
        for(int i=0;i<=nums[n-1];i++){
            c=0;
            for(int j=0;j<n;j++){
                if(nums[j]>=i)c++;
            }
            if(c==i)return i;
        }
        return -1;
    }
};
