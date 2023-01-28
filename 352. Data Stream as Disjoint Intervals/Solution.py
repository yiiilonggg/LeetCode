class SummaryRanges:

    def __init__(self):
        self.flags = [False for i in range(10001)]
        self.high = -1
        self.low = 10001

    def addNum(self, value: int) -> None:
        self.flags[value] = True
        self.high = max(self.high, value)
        self.low = min(self.low, value)

    def getIntervals(self) -> List[List[int]]:
        res = []
        if self.high == -1: return res
        i = self.low
        while i <= self.high:
            interval = [i]
            while i < self.high and self.flags[i + 1]: i += 1
            interval.append(i)
            res.append(interval)
            i += 1
            while i <= self.high and not self.flags[i]: i += 1
        return res


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()