class Solution {
public:
    int low = 16;
    int minimumBeautifulSubstrings(string s) {
        r(s, 0, "", 0);
        return (low < 16) ? low : -1;
    }

    void r(string s, int curr, string x, int count) {
        if (curr == s.length()) {
            if (x == "") {
                low = min(low, count);
            } else {
                if (check(stoi(x, nullptr, 2))) low = min(low, count + 1);
            }
            return;
        }
        if (x == "" && s[curr] == '0') return;
        x += s[curr];
        if (check(stoi(x, nullptr, 2))) r(s, curr + 1, "", count + 1);
        r(s, curr + 1, x, count);
    }

    bool check(int x) {
        if (x == 0) return false;
        while (x > 1) {
            if (x % 5 != 0) return false;
            x /= 5;
        }
        return true;
    }
};
