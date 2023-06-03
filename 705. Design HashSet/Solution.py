class MyHashSet:

    def __init__(self):
        self.buckets = [[] for i in range(31)]

    def add(self, key: int) -> None:
        hash = key % 31
        flag = False
        first = -1
        for i, x in enumerate(self.buckets[hash]):
            if x == key:
                flag = True
            if x == -1 and first == -1:
                first = i
        if not flag:
            if first == -1:
                self.buckets[hash].append(key)
            else:
                self.buckets[hash][first] = key

    def remove(self, key: int) -> None:
        hash = key % 31
        for i, x in enumerate(self.buckets[hash]):
            if x == key: self.buckets[hash][i] = -1

    def contains(self, key: int) -> bool:
        hash = key % 31
        for x in self.buckets[hash]:
            if x == key: return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
