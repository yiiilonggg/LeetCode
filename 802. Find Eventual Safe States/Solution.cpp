class Solution {
public:
    vector<int> loop;
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        loop.assign(n, 0);
        vector<int> res;
        for (int i = 0; i < n; i++) {
            unordered_set<int> s;
            if (dfs(graph, i, s)) res.push_back(i);
        }
        return res;
    }

    bool dfs(vector<vector<int>>& graph, int curr, unordered_set<int>& visited) {
        if (visited.find(curr) != visited.end()) return false;
        if (loop[curr] != 0) return loop[curr] == 1;
        visited.insert(curr);
        for (int neighbour : graph[curr]) {
            if (!dfs(graph, neighbour, visited)) {
                loop[curr] = -1;
                return false;
            }
        }
        visited.erase(curr);
        loop[curr] = 1;
        return true;
    }
};
