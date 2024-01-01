class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        int si=0,c=0,sl=s.size();
        for(auto gi:g){
            while(si<sl&&s[si]<gi)si++;
            if(si<sl){
                c++;
                si++;
            }
        }
        return c;
    }
};
