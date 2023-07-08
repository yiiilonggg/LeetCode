class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if (s.size() != goal.size()) return false;
        unordered_set<char> ch;
        char first = ' ', firstC = ' ', second = ' ', secondC = ' ';
        int l = s.size();
        for (int i = 0; i < l; i++) {
            ch.insert(s[i]);
            if (s[i] == goal[i]) continue;
            if (first == ' ') {
                first = s[i];
                firstC = goal[i];
            } else if (second == ' ') {
                second = s[i];
                secondC = goal[i];
            } else {
                return false;
            }
        }
        if (first == ' ') return ch.size() < l;
        if (second == ' ') return false;
        return first == secondC && firstC == second;
    }
};
