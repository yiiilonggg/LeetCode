class Solution {
public:
    int removeAlmostEqualCharacters(string word) {
        int l = word.length(), res = 0;
        if (l == 1) return 0;
        if (l == 2) return (abs(word[0] - word[1]) <= 1) ? 1 : 0;
        vector<bool> c(l, false);
        for (int i = 1; i < l; i++) {
            if (abs(word[i] - word[i - 1]) > 1) continue;
            if (c[i - 1]) continue;
            c[i] = true;
            res++;
        }
        return res;
    }
};
