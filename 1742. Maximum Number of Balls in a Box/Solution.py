class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        #return max(self.bruteforce(lowLimit, highLimit))
        return max(self.pattern(lowLimit, highLimit))

    def bruteforce(self, lowLimit, highLimit):
        counts = [0 for i in range(46)]
        for i in range(lowLimit, highLimit + 1):
            currSum = 0
            while i > 0:
                currSum += i % 10
                i //= 10
            counts[currSum] += 1
        return counts

    def pattern(self, lowLimit, highLimit):
        counts = [0 for i in range(46)]
        start, pointer = lowLimit, 0
        while start > 0:
            pointer += start % 10
            start //= 10
        counts[pointer] += 1
        for i in range(lowLimit + 1, highLimit + 1):
            while i % 10 == 0:
                pointer -= 9
                i //= 10
            pointer += 1
            counts[pointer] += 1
        return counts
