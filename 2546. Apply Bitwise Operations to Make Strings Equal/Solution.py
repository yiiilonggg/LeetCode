class Solution:
    def makeStringsEqual(self, s: str, target: str) -> bool:
        return bool(s.count('1')) == bool(target.count('1'))