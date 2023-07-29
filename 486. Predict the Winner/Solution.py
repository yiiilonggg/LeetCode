class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        self.unvisited, l = 20 * 10000000, len(nums)
        self.memo = [[[self.unvisited for k in range(l)] for j in range(l)] for i in range(2)]
        return self.r(nums, 0, len(nums) - 1, 0, True) >= 0

    def r(self, arr, left, right, curr, turn):
        if left > right: return curr
        if left == right: return curr + arr[left]
        if self.memo[turn][left][right] != self.unvisited: return curr + self.memo[turn][left][right]
        if turn:
            chooseLeft = self.r(arr, left + 1, right, curr + arr[left], not turn)
            chooseRight = self.r(arr, left, right - 1, curr + arr[right], not turn)
            self.memo[turn][left][right] = max(chooseLeft, chooseRight) - curr
            return max(chooseLeft, chooseRight)
        else:
            chooseLeft = self.r(arr, left + 1, right, curr - arr[left], not turn)
            chooseRight = self.r(arr, left, right - 1, curr - arr[right], not turn)
            self.memo[turn][left][right] = min(chooseLeft, chooseRight) - curr
            return min(chooseLeft, chooseRight)
