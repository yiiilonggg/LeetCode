import heapq

class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        n = len(tasks)
        res = [0 for i in range(n)]
        tasksIndexed = sorted([[task[0], task[1], i] for i, task in enumerate(tasks)])
        q = []
        currTime, taskPointer, resPointer = tasksIndexed[0][0], 0, 0
        while q or taskPointer < n:
            if q:
                processTime, idx = heapq.heappop(q)
                res[resPointer] = idx
                resPointer += 1
                currTime += processTime
            else:
                currTime = tasksIndexed[taskPointer][0]
            while taskPointer < n and tasksIndexed[taskPointer][0] <= currTime:
                heapq.heappush(q, (tasksIndexed[taskPointer][1], tasksIndexed[taskPointer][2]))
                taskPointer += 1
        return res
