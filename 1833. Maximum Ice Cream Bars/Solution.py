class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        # return self.pointers(costs, coins)
        # return self.prefixSum(costs, coins)
        return self.bruteForce(costs, coins)
        
    def pointers(self, costs, coins):
        freq = [0 for i in range(100001)]
        for c in costs: freq[c] += 1
        count = 0
        for i in range(100001):
            if freq[i] == 0: continue
            currMax = min(coins // i, freq[i])
            count += currMax
            coins -= currMax * i
            if (coins <= 0) and (freq[i] - currMax >= 0): break
        return count

    def prefixSum(self, costs, coins):
        costs.sort()
        count, n = 0, len(costs)
        prefix = [0 for i in range(n)]
        for i in range(n):
            prefix[i] = costs[i] if i == 0 else prefix[i - 1] + costs[i]
            if coins < prefix[i]: return i
        return n

    def bruteForce(self, costs, coins):
        costs.sort()
        n = len(costs)
        for i in range(n):
            coins -= costs[i]
            if coins < 0: return i
        return n