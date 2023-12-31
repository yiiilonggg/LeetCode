typedef long long ll;
class Solution {
public:
    int maximumLength(string s) {
        int h=0;
        ll l=0,n=s.length();
        unordered_map<char,unordered_map<int,ll>>f;
        for(ll r=0;r<n;r++){
            if(s[r]!=s[l]){
                for(ll i=l;i<r;i++){
                    f[s[l]][i-l+1]+=r-i;
                }
                l=r;
            }
        }
        for(ll i=l;i<n;i++){
            f[s[l]][i-l+1]+=n-i;
        }
        for(auto[k,v]:f){
            for(auto[a,b]:v){
                if(b>2)h=max(h,(int)a);
            }
        }
        return (h==0)?-1:h;
    }
};
