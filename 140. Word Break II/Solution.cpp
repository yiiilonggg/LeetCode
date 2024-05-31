class Solution {
public:
    vector<string>rs;
    void r(string s,int l,unordered_set<string>&d,vector<int>&p){
        if(l==s.length()){
            l=0;
            string ri="";
            for(auto rg:p){
                ri+=s.substr(l,rg-l);
                l=rg;
                if(l!=s.length())ri+=" ";
            }
            rs.push_back(ri);
        }
        for(int rg=l+1;rg<=s.length();rg++){
            if(d.find(s.substr(l,rg-l))!=d.end()){
                p.push_back(rg);
                r(s,rg,d,p);
                p.pop_back();
            }
        }
    }
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string>d;
        for(auto w:wordDict)d.insert(w);
        vector<int>p;
        r(s,0,d,p);
        return rs;
    }
};
