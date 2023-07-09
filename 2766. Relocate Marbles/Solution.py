class Solution:
    def relocateMarbles(self, nums: List[int], moveFrom: List[int], moveTo: List[int]) -> List[int]:
        d = set(nums)
        for x, y in zip(moveFrom, moveTo):
            if x == y: continue
            d.add(y)
            d.remove(x)
        return sorted(list(d))
