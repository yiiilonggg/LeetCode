class Solution {
public:
    unordered_map<string, unordered_map<string, string>> memo;
    string minimumString(string a, string b, string c) {
        string res = a + b + c;
        for (int i = 0; i < 3; i++) {
            string first = overlap(overlap(a, b), c), second = overlap(overlap(a, c), b);
            if (first.length() < res.length() || (first.length() == res.length() && first < res)) res = first;
            if (second.length() < res.length() || (second.length() == res.length() && second < res)) res = second;
            string temp = a;
            a = b;
            b = c;
            c = temp;
        }
        return res;
    }
    string overlap(string x, string y) {
        if (memo.find(x) != memo.end() && memo[x].find(y) != memo[x].end()) return memo[x][y];
        if (memo.find(x) == memo.end()) {
            unordered_map<string, string> s;
            memo[x] = s;
        }
        int m = x.length(), n = y.length(), overlap = -1;
        for (int i = 0; i < m - n; i++) {
            if (x.substr(i, n) == y) {
                memo[x][y] = x;
                return x;
            }
        }
        for (int i = n; i >= 0; i--) {
            if (i > m) continue;
            if (y.substr(0, i) == x.substr(m - i, i)) {
                overlap = i;
                break;
            }
        }
        memo[x][y] = (overlap == -1) ? x + y : x + y.substr(overlap, n - overlap);
        return memo[x][y];
    }
};
