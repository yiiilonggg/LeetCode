class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        map<string, string> m;
        for (auto p : paths) {
            m[p[0]] = p[1];
        }
        string c = paths[0][1];
        while (m.find(c) != m.end()) {
            c = m[c];
        }
        return c;
    }
};
