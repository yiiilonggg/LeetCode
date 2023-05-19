class Solution {
public:
    vector<vector<int>> g;
    vector<int> col;
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        for (int i = 0; i < n; i++) {
            vector<int> neighbours;
            for (int neighbour : graph[i]) neighbours.push_back(neighbour);
            g.push_back(neighbours);
            col.push_back(0);
        }
        for (int i = 0; i < n; i++) {
            if (col[i] != 0) continue;
            if (!dfs(i, 1)) return false;
        }
        return true;
    }
    bool dfs(int curr, int color) {
        if (col[curr] != 0) return col[curr] == color;
        col[curr] = color;
        for (int neighbour : g[curr]) {
            if (!dfs(neighbour, (color == 2) ? 1 : 2)) return false;
        }
        return true;
    }
};