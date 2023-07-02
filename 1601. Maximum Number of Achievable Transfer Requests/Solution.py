class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        self.res = 0
        self.r(n, requests, [0 for i in range(n)], 0, 0)
        return self.res
    
    def r(self, n, requests, indegree, curr, count):
        if curr == len(requests):
            if any([not (x == 0) for x in indegree]): return
            self.res = max(self.res, count)
            return
        indegree[requests[curr][0]] -= 1
        indegree[requests[curr][1]] += 1
        self.r(n, requests, indegree, curr + 1, count + 1)
        indegree[requests[curr][0]] += 1
        indegree[requests[curr][1]] -= 1
        self.r(n, requests, indegree, curr + 1, count)
