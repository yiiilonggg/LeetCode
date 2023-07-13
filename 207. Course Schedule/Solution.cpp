class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indegree(numCourses, 0);
        vector<vector<int>> graph(numCourses, vector<int>(0, 0));
        queue<int> q;
        int visited = 0;
        for (const auto& p : prerequisites) {
            indegree[p[0]]++;
            graph[p[1]].push_back(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.push(i);
        }
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            visited++;
            for (const auto& neighbour : graph[curr]) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) q.push(neighbour);
            }
        }
        return visited == numCourses;
    }
};
