class Solution:
    def countWays(self, ranges: List[List[int]]) -> int:
        ranges = sorted(ranges, key = itemgetter(0, 1))
        upper, count, res, mod = -1, 0, 1, 10 ** 9 + 7
        for left, right in ranges:
            if left <= upper:
                upper = max(upper, right)
            else:
                count += 1
                upper = right
        for i in range(count):
            res = (res * 2) % mod
        return res