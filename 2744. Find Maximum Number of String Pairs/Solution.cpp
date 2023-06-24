class Solution {
public:
    int maximumNumberOfStringPairs(vector<string>& words) {
        int count = 0, n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(words[i], words[j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    bool check(string a, string b) {
        if (a.length() != b.length()) return false;
        int l = a.length();
        for (int i = 0; i < l; i++) {
            if (a[i] != b[l - i - 1]) return false;
        }
        return true;
    }
};
