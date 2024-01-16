class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        vector<int>f(101,0);
        for(auto n:nums)f[n]++;
        int h=0,s=0;
        for(auto fi:f){
            if(fi>h){
                h=fi;
                s=fi;
            }else if(fi==h){
                s+=fi;
            }
        }
        return s;
    }
};
