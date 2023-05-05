class Solution {
public:
    int maxVowels(string s, int k) {
        unordered_set<char> vowels;
        vowels.insert('a');
        vowels.insert('e');
        vowels.insert('o');
        vowels.insert('i');
        vowels.insert('u');
        int count = 0, res = 0, n = s.length();
        for (int i = 0; i < k; i++) {
            if (vowels.find(s[i]) != vowels.end()) count++;
        }
        res = count;
        for (int i = k, j = 0; i < n; i++, j++) {
            if (vowels.find(s[j]) != vowels.end()) count--;
            if (vowels.find(s[i]) != vowels.end()) count++;
            res = max(res, count);
        }
        return res;
    }
};