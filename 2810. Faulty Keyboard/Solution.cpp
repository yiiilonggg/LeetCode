class Solution {
public:
    string finalString(string s) {
        string f = "";
        for (char c : s) {
            if (c == 'i') {
                reverse(begin(f), end(f));
            } else {
                f += c;
            }
        }
        return f;
    }
};
