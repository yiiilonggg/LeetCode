class FrequencyTracker:

    def __init__(self):
        self.freq = [0 for i in range(100001)]
        self.nums = dict()

    def add(self, number: int) -> None:
        if number in self.nums: self.freq[self.nums[number]] -= 1
        self.nums[number] = 1 if number not in self.nums else self.nums[number] + 1
        self.freq[self.nums[number]] += 1

    def deleteOne(self, number: int) -> None:
        if number not in self.nums or self.nums[number] == 0: return
        self.freq[self.nums[number]] -= 1
        self.freq[self.nums[number] - 1] += 1
        self.nums[number] = self.nums[number] - 1

    def hasFrequency(self, frequency: int) -> bool:
        return self.freq[frequency] > 0


# Your FrequencyTracker object will be instantiated and called as such:
# obj = FrequencyTracker()
# obj.add(number)
# obj.deleteOne(number)
# param_3 = obj.hasFrequency(frequency)