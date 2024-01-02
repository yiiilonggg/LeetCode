class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int,int>f;
        for(auto n:nums)f[n]++;
        int l=nums.size();
        vector<vector<int>>r;
        while(l){
            vector<int>c;
            for(auto[k,v]:f){
                if(v>0)c.push_back(k);
                f[k]--;
            }
            l-=c.size();
            r.push_back(c);
        }
        return r;
    }
};
