class Solution {
    int res = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        r(n, requests, indegree, 0, 0);
        return res;
    }

    public void r(int n, int[][] requests, int[] indegree, int curr, int count) {
        if (curr == requests.length) {
            for (int d : indegree) {
                if (d != 0) return;
            }
            res = Math.max(res, count);
            return;
        }
        indegree[requests[curr][0]]--;
        indegree[requests[curr][1]]++;
        r(n, requests, indegree, curr + 1, count + 1);
        indegree[requests[curr][0]]++;
        indegree[requests[curr][1]]--;
        r(n, requests, indegree, curr + 1, count);
    }
}
