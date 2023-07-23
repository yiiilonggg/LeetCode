class Solution {
public:
    string sortVowels(string s) {
        unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        vector<char> vs;
        vector<int> ps;
        int l = s.size();
        for (int i = 0; i < l; i++) {
            if (vowels.find(s[i]) != vowels.end()) {
                vs.push_back(s[i]);
                ps.push_back(i);
            }
        }
        sort(begin(vs), end(vs));
        int i = 0;
        for (int p : ps) {
            s[p] = vs[i];
            i++;
        }
        return s;
    }
};
