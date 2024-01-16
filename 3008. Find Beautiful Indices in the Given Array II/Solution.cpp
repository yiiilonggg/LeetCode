class Solution {
public:
    void kmp(string t,string p,vector<int>&f){
        string s=p+"#"+t;
        f.push_back(0);
        for(int i=1;i<s.length();i++){
            int c=f[i-1];
            while(c>0&&s[i]!=s[c])c=f[c-1];
            f.push_back(c+(s[i]==s[c]));
        }
    }

    vector<int> beautifulIndices(string s, string a, string b, int k) {
        vector<int>af,bf;
        kmp(s,a,af);
        kmp(s,b,bf);
        vector<int>ar,br;
        for(int i=0;i<af.size();i++){
            if(af[i]<a.length())continue;
            ar.push_back(i-2*a.length());
        }
        for(int i=0;i<bf.size();i++){
            if(bf[i]<b.length())continue;
            br.push_back(i-2*b.length());
        }
        int j=0;
        vector<int>r;
        for(auto ari:ar){
            while(j<br.size()&&br[j]<ari-k)j++;
            if(j<br.size()&&br[j]<=ari+k)r.push_back(ari);
        }
        return r;
    }
};
