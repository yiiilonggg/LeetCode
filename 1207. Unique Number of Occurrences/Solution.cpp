class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        unordered_map<int,int>f;
        for(auto ai:arr)f[ai]++;
        unordered_set<int>s;
        for(auto [k,v]:f){
            if(s.find(v)!=s.end())return 0;
            s.insert(v);
        }
        return 1;
    }
};
