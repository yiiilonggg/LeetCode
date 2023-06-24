class Solution:
    def longestString(self, x: int, y: int, z: int) -> int:
        return (2 * min(x, y) + z + 1) * 2 if x != y else (2 * min(x, y) + z) * 2
