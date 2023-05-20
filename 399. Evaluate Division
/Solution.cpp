class Solution {
public:
    unordered_map<string, vector<pair<string, double>>> graph;
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        int q = queries.size(), e = equations.size();
        vector<double> res(q, 0);
        for (int i = 0; i < e; i++) {
            if (graph.find(equations[i][0]) == graph.end()) {
                vector<pair<string, double>> x;
                graph[equations[i][0]] = x;
            }
            if (graph.find(equations[i][1]) == graph.end()) {
                vector<pair<string, double>> y;
                graph[equations[i][1]] = y;
            }
            graph[equations[i][0]].push_back(pair(equations[i][1], values[i]));
            graph[equations[i][1]].push_back(pair(equations[i][0], 1 / values[i]));
        }
        for (int i = 0; i < q; i++) {
            unordered_set<string> visited;
            res[i] = dfs(queries[i][0], queries[i][1], visited, 1);
        }
        return res;
    }

    double dfs(string curr, string target, unordered_set<string> visited, double v) {
        if (visited.find(curr) != visited.end() || graph.find(curr) == graph.end()) return -1;
        if (curr == target) return v;
        visited.insert(curr);
        for (pair<string, double> neighbour : graph[curr]) {
            double foll = dfs(neighbour.first, target, visited, v * neighbour.second);
            if (foll != -1) return foll;
        }
        return -1;
    }
};