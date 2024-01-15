class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_map<int,int>ls;
        unordered_set<int>ps;
        for(auto mi:matches){
            ls[mi[1]]++;
            ps.insert(mi[0]);
            ps.insert(mi[1]);
        }
        vector<int>nw,lo;
        for(auto pi:ps){
            if(ls[pi]==0)nw.push_back(pi);
            if(ls[pi]==1)lo.push_back(pi);
        }
        sort(nw.begin(),nw.end());
        sort(lo.begin(),lo.end());
        return {nw,lo};
    }
};
