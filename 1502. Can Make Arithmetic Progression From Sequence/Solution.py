class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr = sorted(arr)
        diff, n = arr[1] - arr[0], len(arr)
        for i in range(2, n):
            if diff != arr[i] - arr[i - 1]: return False
        return True
