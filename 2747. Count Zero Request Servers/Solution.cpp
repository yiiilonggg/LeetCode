class Solution {
public:
    vector<int> countServers(int n, vector<vector<int>>& logs, int x, vector<int>& queries) {
        int l = queries.size(), m = logs.size();
        vector<int> queriesS(l, 0), res(l, 0);
        unordered_map<int, int> temp, active;
        for (int i = 0; i < l; i++) {
            queriesS[i] = queries[i];
            temp[queries[i]] = i;
        }
        sort(begin(logs), end(logs), [](const auto& a, const auto& b) { return a[1] < b[1]; });
        sort(begin(queriesS), end(queriesS));
        int left = 0, right = 0;
        for (int q : queriesS) {
            while (left < m && logs[left][1] < q - x) {
                if (active.find(logs[left][0]) != active.end()) {
                    active[logs[left][0]]--;
                    if (active[logs[left][0]] == 0) active.erase(logs[left][0]);
                }
                left++;
            }
            right = max(left, right);
            while (right < m && logs[right][1] <= q) {
                active[logs[right][0]] = (active.find(logs[right][0]) == active.end()) ? 1 : active[logs[right][0]] + 1;
                right++;
            }
            temp[q] = n - active.size();
        }
        for (int i = 0; i < l; i++) {
            res[i] = temp[queries[i]];
        }
        return res;
        
    }
};
