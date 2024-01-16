class RandomizedSet:

    def __init__(self):
        self.indices = dict()
        self.arr = []

    def insert(self, val: int) -> bool:
        if val in self.indices: return False
        self.indices[val] = len(self.arr)
        self.arr.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.indices: return False
        idx = self.indices[val]
        self.indices[self.arr[-1]] = idx
        self.arr[idx] = self.arr[-1]
        self.arr.pop()
        del self.indices[val]
        return True

    def getRandom(self) -> int:
        return random.choice(self.arr)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
