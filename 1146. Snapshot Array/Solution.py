class SnapshotArray:

    def __init__(self, length: int):
        self.arr = [[[0, 0]] for i in range(length)]
        self.s = 0

    def set(self, index: int, val: int) -> None:
        if self.arr[index] and self.arr[index][-1][0] == self.s:
            self.arr[index][-1][1] = val
        else:
            self.arr[index].append([self.s, val])

    def snap(self) -> int:
        self.s += 1
        return self.s - 1

    def get(self, index: int, snap_id: int) -> int:
        arr = self.arr[index]
        left, right = 0, len(arr) - 1
        while left <= right:
            mid = (left + right) // 2
            if arr[mid][0] <= snap_id:
                left = mid + 1
            else:
                right = mid - 1
        return arr[left - 1][1] if left < len(arr) else arr[-1][1]

# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
