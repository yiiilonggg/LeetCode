class Solution {
public:
    string smallestString(string s) {
        bool change = false;
        int l = s.length(), i =  0;
        while (i < l && s[i] == 'a') i += 1;
        if (i == l) return s.substr(0, l - 1) + "z";
        while (i < l && s[i] != 'a') {
            s[i] = (char) (s[i] - 1);
            i += 1;
        }
        return s;
        
    }
};
