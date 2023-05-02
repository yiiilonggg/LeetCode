class Solution {
public:
    string smallestBeautifulString(string s, int k) {
        int n = s.length(), i = n - 1;
        while (i >= 0) {
            s[i]++;
            if (s[i] == char('a' + k)) {
                i--;
            } else if ((i - 1 < 0 || s[i - 1] != s[i]) && (i - 2 < 0 || s[i - 2] != s[i])) {
                for (int j = i + 1; j < n; j++) {
                    vector<bool> can(3, true);
                    for (int l = max(0, j - 2); l < j; l++) {
                        if (s[l] - 'a' > 2) continue;
                        can[s[l] - 'a'] = false;
                    }
                    for (int l = 0; l < 3; l++) {
                        if (can[l] == true) {
                            s[j] = char(l + 'a');
                            break;
                        }
                    }
                }
                return s;
            }
        }
        return "";
    }
};