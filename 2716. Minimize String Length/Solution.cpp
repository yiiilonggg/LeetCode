class Solution {
public:
    int minimizedStringLength(string s) {
        unordered_set<char> seen;
        for (char c : s) seen.insert(c);
        return seen.size();
    }
};
