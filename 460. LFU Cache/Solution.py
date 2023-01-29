class LFUCache:

    def __init__(self, capacity: int):
        self.tracker = dict()
        self.freqQueues = dict()
        self.counter = [0 for i in range(100001)]
        self.freqQueues[1] = []
        self.lowFreq = 1
        self.currSize = 0
        self.maxSize = capacity

    def get(self, key: int) -> int:
        if key not in self.tracker: return -1
        self.counter[key] += 1
        if self.counter[key] not in self.freqQueues: self.freqQueues[self.counter[key]] = []
        self.freqQueues[self.counter[key]].append(key)
        return self.tracker[key]

    def put(self, key: int, value: int) -> None:
        if key not in self.tracker:
            if self.maxSize == 0: return
            if self.currSize == self.maxSize:
                found = False
                while not found:
                    curr = self.freqQueues[self.lowFreq]
                    while not found and curr:
                        candidate = curr.pop(0)
                        if self.counter[candidate] != self.lowFreq: continue
                        del self.tracker[candidate]
                        self.counter[candidate] = 0
                        found = True
                    if not found: self.lowFreq += 1
            else:
                self.currSize += 1
            self.lowFreq = 1
        self.counter[key] += 1
        if self.counter[key] not in self.freqQueues: self.freqQueues[self.counter[key]] = []
        self.freqQueues[self.counter[key]].append(key)
        self.tracker[key] = value

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)