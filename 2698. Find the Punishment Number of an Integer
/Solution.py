class Solution:
    def punishmentNumber(self, n: int) -> int:
        p = [1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000]
        res = 0
        for i in p:
            if i <= n: res += i * i
        return res
    
    def find(self, x, target, curr):
        if curr > target: return False
        if curr == target and not x: return True
        n = len(x)
        for j in range(1, n + 1):
            if curr + int(x[:j]) > target: return False
            if self.find(x[j:], target, curr + int(x[:j])): return True
        return False
