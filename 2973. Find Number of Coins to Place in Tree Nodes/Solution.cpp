class Solution {
public:
    vector<long long> placedCoins(vector<vector<int>>& edges, vector<int>& cost) {
        int n = cost.size();
        vector<vector<int>> graph(n, vector<int>());
        vector<long long> coin(n, 0);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        dfs(graph, cost, coin, 0, -1);
        return coin;
    }
    vector<long long> ss(vector<long long> a) {
        sort(a.begin(), a.end());
        return { a[0], a[1], a[a.size() - 3], a[a.size() - 2], a[a.size() - 1] };
    }
    vector<long long> dfs(vector<vector<int>>& graph, vector<int>& cost, vector<long long>& coin, int curr, int prev) {
        int s = 1;
        vector<long long> best = { cost[curr], 0, 0, 0, 0 };
        for (auto n : graph[curr]) {
            if (n == prev) continue;
            vector<long long> r = dfs(graph, cost, coin, n, curr);
            s += r[5];
            for (int i = 0; i < 5; i++) best.push_back(r[i]);
        }
        best = ss(best);
        coin[curr] = (s < 3) ? 1 : max(0ll, max(1ll * best[2] * best[3] * best[4], 1ll * best[0] * best[1] * best[4]));
        best.push_back(s);
        return best;
    }
};
