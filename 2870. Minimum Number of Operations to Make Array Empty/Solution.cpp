class Solution {
public:
    int minOperations(vector<int>& nums) {
        int s=0;
        unordered_map<int,int>f;
        for(auto n:nums)f[n]++;
        for(auto[k,v]:f){
            if(v==1)return -1;
            if(v%3==0){
                s+=v/3;
            }else{
                s+=v/3+1;
            }
        }
        return s;
    }
};
