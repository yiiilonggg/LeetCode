class Solution {
public:
    int res = 0;
    int numberOfSets(int n, int maxDistance, vector<vector<int>>& roads) {
        dfs(0, n, maxDistance, roads, 0);
        return res;
    }
    
    void dfs(int curr, int n, int high, vector<vector<int>>& roads, int exclude) {
        res += check(n, high, roads, exclude);
        if (curr == n) return;
        for (int i = curr; i < n; i++) {
            exclude ^= (1 << i);
            dfs(i + 1, n, high, roads, exclude);
            exclude ^= (1 << i);
        }
    }
    
    int check(int n, int high, vector<vector<int>>& roads, int exclude) {
        vector<vector<long>> graph(n, vector<long>(n, INT_MAX));
        for (vector<int> r : roads) {
            if (unmask(exclude, r[0]) || unmask(exclude, r[1]) != 0) continue;
            graph[r[0]][r[1]] = min(graph[r[0]][r[1]], r[2] * 1l);
            graph[r[1]][r[0]] = min(graph[r[1]][r[0]], r[2] * 1l);
        }
        long c = 0;
        for (int k = 0; k < n; k++) {
            if (unmask(exclude, k)) continue;
            for (int i = 0; i < n; i++) {
                if (unmask(exclude, i)) continue;
                for (int j = 0; j < n; j++) {
                    if (unmask(exclude, j)) continue;
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (unmask(exclude, i)) continue;
            for (int j = i + 1; j < n; j++) {
                if (unmask(exclude, j)) continue;
                if (graph[i][j] == INT_MAX) return 0;
                c = max(c, graph[i][j]);
            }
        }
        return (c > high) ? 0 : 1;
    }
    
    bool unmask(int mask, int poll) {
        return (mask & (1 << poll)) != 0;
    }
};
