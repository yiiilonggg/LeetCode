class Solution {
public:
    bool isFascinating(int n) {
        string s = to_string(n) + to_string(2 * n) + to_string(3 * n);
        unordered_set<char> seen;
        for (char ch : s) {
            seen.insert(ch);
            if (ch == '0') return false;
        }
        return seen.size() == 9 && s.length() == 9;
    }
};
