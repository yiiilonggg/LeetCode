class Solution {
public:
    string makeSmallestPalindrome(string s) {
        vector<char> ch;
        int n = s.length();
        for (int i = 0; i < n; i++) ch.push_back(s[i]);
        for (int i = 0; i < n / 2; i++) {
            char c = min(ch[i], ch[n - i - 1]);
            ch[i] = c;
            ch[n - i - 1] = c;
        }
        string res(begin(ch), end(ch));
        return res;
    }
};
