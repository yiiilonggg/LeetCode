class Solution {
public:
    int maximumLength(string s) {
        int h=0,l=0,n=s.length();
        unordered_map<string,int>f;
        for(int r=0;r<n;r++){
            if(s[r]!=s[l]){
                for(int i=l;i<r;i++){
                    f[s.substr(l,i-l+1)]+=r-i;
                }
                l=r;
            }
        }
        for(int i=l;i<n;i++){
            f[s.substr(l,i-l+1)]+=n-i;
        }
        for(auto[k,v]:f){
            if(v>2)h=max(h,(int)k.length());
        }
        return (h==0)?-1:h;
    }
};
