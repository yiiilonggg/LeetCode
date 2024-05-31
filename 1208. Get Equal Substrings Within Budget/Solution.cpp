class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int n=s.length(),l=0,h=0,p=0;
        vector<int>c(n,0);
        for(int i=0;i<n;i++)c[i]=abs(s[i]-t[i]);
        for(int r=0;r<n;r++){
            p+=c[r];
            while(p>maxCost){
                p-=c[l];
                l++;
            }
            h=max(h,r-l+1);
        }
        return h;
    }
};
