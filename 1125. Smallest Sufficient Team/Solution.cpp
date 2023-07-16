class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        int n = req_skills.size(), m = people.size();
        unordered_map<string, int> skill;
        for (int i = 0; i < n; i++) skill[req_skills[i]] = i;
        vector<int> pmask(m, 0);
        unordered_map<int, vector<int>> dp;
        for (int i = 0; i < (1 << n); i++) {
            vector<int> d;
            dp[i] = d;
        }
        for (int i = 0; i < m; i++) {
            for (const auto& c : people[i]) {
                pmask[i] |= (1 << skill[c]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (const auto& [k, v] : dp) {
                if (k != 0 && v.size() == 0) continue;
                int curr = k | pmask[i];
                if (curr == k) continue;
                if (dp[curr].size() == 0 || dp[curr].size() > v.size() + 1) {
                    vector<int> nteam;
                    for (const auto& t : v) nteam.push_back(t);
                    nteam.push_back(i);
                    dp[curr] = nteam;
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};
