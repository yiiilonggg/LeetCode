class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(cost) > sum(gas): return -1
        n, currStart, currSum = len(gas), 0, 0
        for i in range(n):
            currSum += gas[i] - cost[i]
            if currSum < 0: currStart, currSum = i + 1, 0
        return currStart