class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        vector<bool> visited(n, false);
        auto cmp = [](const auto& a, const auto& b) { return a.first > b.first; };
        priority_queue<pair<double, int>, vector<pair<double, int>>, decltype(cmp)> pq(cmp);
        vector<vector<pair<int, double>>> graph(n, vector<pair<int, double>>());
        for (int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back(pair<int, double>(edges[i][1], log(succProb[i])));
            graph[edges[i][1]].push_back(pair<int, double>(edges[i][0], log(succProb[i])));
        }
        pq.push(pair<double, int>(0, start));
        while (!pq.empty()) {
            pair<double, int> curr = pq.top();
            pq.pop();
            if (visited[curr.second]) continue;
            visited[curr.second] = true;
            if (curr.second == end) return exp(-curr.first);
            for (pair<int, double> neighbour : graph[curr.second]) {
                if (visited[neighbour.first]) continue;
                pq.push(pair<double, int>(curr.first - neighbour.second, neighbour.first));
            }
        }
        return 0;
    }
};
