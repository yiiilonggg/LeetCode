class Solution {
public:
    int minSteps(string s, string t) {
        vector<int>f(26,0);
        for(char c:s)f[c-'a']++;
        for(char c:t)f[c-'a']--;
        int c=0;
        for(int fi:f)c+=abs(fi);
        return c/2;
    }
};
