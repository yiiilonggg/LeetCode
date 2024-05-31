class Solution {
public:
    int numSteps(string s) {
        int l=s.length(),r=0;
        deque<int>t;
        for(int i=0;i<l;i++)t.push_back(s[i]-'0');
        while(t.size()>1){
            if(t.back()){
                r+=2;
                t.pop_back();
                while(!t.empty()&&t.back()){
                    r++;
                    t.pop_back();
                }
                if(!t.empty())t.pop_back();
                t.push_back(1);
            }else{
                r++;
                t.pop_back();
            }
        }
        return r;
    }
};
