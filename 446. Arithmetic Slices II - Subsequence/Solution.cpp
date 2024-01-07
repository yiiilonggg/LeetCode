typedef long long ll;
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        vector<unordered_map<ll,ll>>m(nums.size(),unordered_map<ll,ll>());
        ll t=0;
        for (int i=1;i<nums.size();i++){
            for(int j=0;j<i;j++){
                ll d=1ll*nums[i]-1ll*nums[j];
                t+=m[j][d];
                m[i][d]=m[i][d]+m[j][d]+1;
            }
        }
        return (int)t;
    }
};
