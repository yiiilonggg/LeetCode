class Solution {
public:
    int res = 0;
    int maximumRequests(int n, vector<vector<int>>& requests) {
        vector<int> indegree(n, 0);
        r(n, requests, indegree, 0, 0);
        return res;
    }
    void r(int n, vector<vector<int>>& requests, vector<int> indegree, int curr, int count) {
        if (curr == requests.size()) {
            for (int d : indegree) {
                if (d != 0) return;
            }
            res = max(res, count);
            return;
        }
        indegree[requests[curr][0]]--;
        indegree[requests[curr][1]]++;
        r(n, requests, indegree, curr + 1, count + 1);
        indegree[requests[curr][0]]++;
        indegree[requests[curr][1]]--;
        r(n, requests, indegree, curr + 1, count);
    }
};
