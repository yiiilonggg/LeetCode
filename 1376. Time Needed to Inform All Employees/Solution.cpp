class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        int high = 0;
        vector<vector<pair<int, int>>> graph;
        for (int i = 0; i < n; i++) {
            vector<pair<int, int>> node;
            graph.push_back(node);
        }
        for (int i = 0; i < n; i++) {
            if (i == headID) continue;
            graph[manager[i]].push_back(pair(i, informTime[manager[i]]));
        }
        queue<pair<int, int>> q;
        q.push(pair(headID, 0));
        while (!q.empty()) {
            int curr = q.front().first, time = q.front().second;
            high = max(high, time);
            q.pop();
            for (pair<int, int> neighbour : graph[curr]) {
                q.push(pair(neighbour.first, neighbour.second + time));
            }
        }
        return high;
    }
};
