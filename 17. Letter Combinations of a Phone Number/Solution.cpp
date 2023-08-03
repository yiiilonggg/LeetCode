class Solution {
public:
    unordered_map<char, vector<string>> keys = {
        {'2', {"a", "b", "c"}},
        {'3', {"d", "e", "f"}},
        {'4', {"g", "h", "i"}},
        {'5', {"j", "k", "l"}},
        {'6', {"m", "n", "o"}},
        {'7', {"p", "q", "r", "s"}},
        {'8', {"t", "u", "v"}},
        {'9', {"w", "x", "y", "z"}},
    };
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if (digits.length() == 0) return res;
        if (digits.length() == 1) return keys[digits[0]];
        for (const auto& k : keys[digits[0]]) {
            for (const auto& foll : letterCombinations(digits.substr(1))) {
                res.push_back(k + foll);
            }
        }
        return res;
    }
};
