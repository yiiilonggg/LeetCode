class Solution {
public:
    vector<vector<int>> graph;
    int maximumDetonation(vector<vector<int>>& bombs) {
        int n = bombs.size(), high = 0;
        for (int i = 0; i < n; i++) {
            vector<int> neighbours;
            graph.push_back(neighbours);
        }
        for (int i = 0; i < n; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int a = bombs[j][0], b = bombs[j][1];
                if (1L * (x - a) * (x - a) + 1L * (y - b) * (y - b) > 1L * r * r) continue;
                graph[i].push_back(j);
            }
        }
        for (int i = 0; i < n; i++) {
            unordered_set<int> seen;
            high = max(high, dfs(i, seen));
        }
        return high;
    }
    int dfs(int curr, unordered_set<int>& seen) {
        if (seen.find(curr) != seen.end()) return 0;
        seen.insert(curr);
        int total = 1;
        for (int neighbour : graph[curr]) total += dfs(neighbour, seen);
        return total;
    }
};
