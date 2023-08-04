class Solution {
public:
    unordered_set<int> memo;
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> d;
        for (const auto& w : wordDict) d.insert(w);
        return r(s, d, 0);
    }
    bool r(string s, unordered_set<string> d, int i) {
        if (i == s.length()) return true;
        if (memo.find(i) != memo.end()) return false;
        for (int j = 1; j < s.length() - i + 1; j++) {
            if (d.find(s.substr(i, j)) != d.end() && r(s, d, i + j)) return true;
        }
        memo.insert(i);
        return false;
    }
};
