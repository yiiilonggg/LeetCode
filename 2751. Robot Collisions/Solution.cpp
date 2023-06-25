class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        vector<vector<int>> comb(n, vector<int>(3, 0));
        for (int i = 0; i < n; i++) {
            comb[i][0] = positions[i];
            comb[i][1] = healths[i];
            comb[i][2] = (int) (directions[i] - 'L');
        }
        sort(begin(comb), end(comb), [](const auto& a, const auto& b) { return a[0] < b[0]; });
        unordered_map<int, int> res;
        int i = 0;
        while (i < n && comb[i][2] == 0) {
            res[comb[i][0]] = comb[i][1];
            i++;
        }
        deque<vector<int>> stack;
        while (i < n) {
            if (comb[i][2] != 0) {
                stack.push_back(comb[i]);
            } else {
                bool flag = false;
                while (!stack.empty()) {
                    if (stack.back()[1] == comb[i][1]) {
                        stack.pop_back();
                        flag = true;
                        break;
                    } else if (stack.back()[1] < comb[i][1]) {
                        comb[i][1]--;
                        stack.pop_back();
                    } else {
                        stack.back()[1]--;
                        break;
                    }
                }
                if (stack.empty() && !flag) {
                    res[comb[i][0]] = comb[i][1];
                }
            }
            i++;
        }
        for (const auto& s : stack) res[s[0]] = s[1];
        vector<int> f;
        for (const auto& p : positions) {
            if (res.find(p) != res.end()) f.push_back(res[p]);
        }
        return f;
    }
};
