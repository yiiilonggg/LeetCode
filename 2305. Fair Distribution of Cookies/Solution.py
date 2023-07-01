class Solution:
    def distributeCookies(self, cookies: List[int], k: int) -> int:
        self.low = sum(cookies)
        self.r(cookies, k, 0, [0 for i in range(k)], k, 0)
        return self.low
    
    def r(self, cookies, k, curr, kids, zero, high):
        if len(cookies) - curr < zero: return
        if curr == len(cookies):
            self.low = min(self.low, high)
            return
        if high > self.low: return
        for i in range(k):
            zero = zero if kids[i] > 0 else zero - 1
            kids[i] += cookies[curr]
            self.r(cookies, k, curr + 1, kids, zero, max(high, kids[i]))
            kids[i] -= cookies[curr]
            zero = zero if kids[i] > 0 else zero + 1
