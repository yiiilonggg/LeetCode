class Solution {
public:
    bool hasTrailingZeros(vector<int>& nums) {
        long c=0;
        for(int n:nums){
            if(n%2==0)c++;
        }
        return c>1;
    }
};
