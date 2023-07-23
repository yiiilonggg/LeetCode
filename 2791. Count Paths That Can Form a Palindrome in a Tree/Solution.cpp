class Solution {
public:
    long long countPalindromePaths(vector<int>& parent, string s) {
        int n = parent.size();
        long long res = 0;
        vector<vector<int>> graph(n, vector<int>(0, 0));
        for (int i = 1; i < n; i++) {
            graph[parent[i]].push_back(i);
        }
        deque<pair<int, int>> q;
        q.push_back(pair(0, 0));
        unordered_map<int, long long> masks;
        while (!q.empty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                pair<int, int> curr = q.front();
                q.pop_front();
                if (masks.find(curr.second) != masks.end()) res += masks[curr.second];
                masks[curr.second] = (masks.find(curr.second) != masks.end()) ? masks[curr.second] + 1 : 1;
                for (int j = 0; j < 26; j++) {
                    int nmask = curr.second ^ (1 << j);
                    if (masks.find(nmask) != masks.end()) res += masks[nmask];
                }
                for (int neighbour : graph[curr.first]) {
                    int nmask = curr.second ^ (1 << (int) (s[neighbour] - 'a'));
                    q.push_back(pair(neighbour, nmask));
                }
            }
        }
        return res;
    }
};
