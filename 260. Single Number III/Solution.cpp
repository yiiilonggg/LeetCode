class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int a=0,b=0;
        vector<int>r(2,0);
        for(auto n:nums)a^=n;
        while(1){
            if((a&(1<<b)))break;
            b++;
        }
        for(auto n:nums)r[(n&(1<<b))==0]^=n;
        return r;
    }
};
