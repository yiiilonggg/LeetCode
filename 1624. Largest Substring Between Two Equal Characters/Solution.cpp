class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        int l=s.length(),h=-1;
        vector<int>p(26,-1);
        for(int i=0;i<l;i++){
            if(p[s[i]-'a']==-1){
                p[s[i]-'a']=i;
            }else{
                h=max(h,i-p[s[i]-'a']-1);
            }
        }
        return h;
    }
};
