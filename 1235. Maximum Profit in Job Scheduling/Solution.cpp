typedef long long ll;
class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int l=startTime.size();
        ll h=0;
        map<ll,ll>dp;
        dp[0]=0;
        vector<vector<ll>>ps;
        for(int i=0;i<l;i++)ps.push_back({startTime[i],endTime[i],profit[i]});
        sort(ps.begin(),ps.end(),[](const auto&a,const auto&b){return a[0]>b[0];});
        for(auto pi:ps){
            ll c=(dp.lower_bound(pi[1])!=dp.end())?dp.lower_bound(pi[1])->second+pi[2]:pi[2];
            h=max(h,c);
            dp[pi[0]]=h;
        }
        return h;
    }
};
