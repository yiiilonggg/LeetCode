class Solution {
public:
    bool halvesAreAlike(string s) {
        unordered_set<char>v={'a','e','i','o','u'};
        int l=s.length(),vs=0;
        for(int i=0;i<l/2;i++)if(v.find(tolower(s[i]))!=v.end())vs++;
        for(int i=l/2;i<l;i++)if(v.find(tolower(s[i]))!=v.end())vs--;
        return vs==0;
    }
};
